package web.servlet.operator;

import service.OperatorService;
import service.impl.OperatorServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectOperatorServlet")
public class DeleteSelectOperatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] sids = request.getParameterValues("sid");
        OperatorService service = new OperatorServiceImpl();
        service.deleteSelectOperator(sids);
        response.sendRedirect(request.getContextPath()+"/findOperatorByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
