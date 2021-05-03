package web.servlet.operator;

import domain.Operator;

import domain.SelectLine;
import service.OperatorService;

import service.impl.OperatorServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/doSelectLineServlet")
public class DoSelectLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Operator operator= (Operator) session.getAttribute("operator");
        String lineid = request.getParameter("id");
        //存不存在已选该课
        boolean flag = false;

        //判断是否已选
        OperatorService operatorService = new OperatorServiceImpl();
        List<SelectLine> selectlines = operatorService.findAllSelectLine(operator.getS_id());
        for (SelectLine s:selectlines) {
            if (s.getC_id().equals(lineid)) {
                flag = true;
                break;
            }
        }
        if (flag == true) {

            request.setAttribute("select_msg", "你已选了该线体！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("studentOptionalCourseServlet").forward(request, response);
//            response.sendRedirect("studentOptionalCourseServlet");
        } else {
            //获取到当前学生id
            String operatorid = operator.getS_id();

            //获取当前行的课程id courseid

            //调用学生添加选课服务s_id c_id score  select_course添加
            OperatorService Service = new OperatorServiceImpl();
            Service.addSelectLine(operatorid,lineid);

            //完成后给提示跳转
            request.setAttribute("select_msg", "选课成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("operatorOptionalLineServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
