package web.servlet.page;

import domain.Admin;
import domain.Leader;
import domain.Operator;
import domain.PageBean;
import service.OperatorService;
import service.impl.OperatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findOperatorByPageServlet")
public class FindOperatorByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        //获取条件查询参数
        Map<String,String[]> condition = request.getParameterMap();

        OperatorService service = new OperatorServiceImpl();
        PageBean<Operator> pb =  service.findOperatorByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//存入查询条件
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Operator operator= (Operator) session.getAttribute("operator");

        Admin admin= (Admin)session.getAttribute("admin");
        Leader leader= (Leader)session.getAttribute("leader");
        if (operator != null && admin == null && leader == null) {
            request.getRequestDispatcher("/WEB-INF/operator/oFindOperatorList.jsp").forward(request, response);
        } else if (admin != null && operator == null && leader == null) {
            request.getRequestDispatcher("/WEB-INF/admin/aFindStudentList.jsp").forward(request, response);
        } else if (leader != null && admin == null && operator == null) {
            request.getRequestDispatcher("/WEB-INF/leader/lFindOperatorList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
