package web.servlet.operator;

import domain.Admin;
import domain.Line;
import domain.Operator;
import service.impl.OperatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/operatorOptionalLineServlet")
public class OperatorOptionalLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Operator operator= (Operator)session.getAttribute("operator");
        Admin admin =(Admin)session.getAttribute("admin");
        //调用OperatorService完成查询
        OperatorServiceImpl operatorService = new OperatorServiceImpl();
        List<Line> optionallines = operatorService.findAllOptionalLine();
        //将list存入request域
        request.setAttribute("optionallines" ,optionallines);
        //转发到list.jpg
        if (operator != null && admin == null) {
            request.getRequestDispatcher("/WEB-INF/operator/operatorOptionalLine.jsp").forward(request,response);
        } else if (admin != null && operator == null) {
            request.getRequestDispatcher("/WEB-INF/admin/allStudentOptionalLine.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
