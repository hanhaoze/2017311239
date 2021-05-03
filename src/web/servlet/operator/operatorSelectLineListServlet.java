package web.servlet.operator;

import domain.Admin;
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
import java.util.List;

@WebServlet("/operatorSelectLineListServlet")
public class operatorSelectLineListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Operator operator= (Operator) session.getAttribute("operator");
        Admin admin =(Admin)session.getAttribute("admin");

        //调用StudentService完成查询
        OperatorService operatorService = new OperatorServiceImpl();

        if (operator != null && admin == null) {
            List<SelectLine> selectlines = operatorService.findAllSelectLine(operator.getS_id());
            //将list存入request域
            request.setAttribute("selectlines",selectlines);
            //转发到list.jsp
            request.getRequestDispatcher("/WEB-INF/operator/operatorSelectLineList.jsp").forward(request,response);
        } else if (admin != null && operator == null) {
            List<SelectLine> selectlines = operatorService.findSelectLineAllOperator();
            request.setAttribute("selectlines", selectlines);
            request.getRequestDispatcher("/WEB-INF/admin/allOperatorSelectLineList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
