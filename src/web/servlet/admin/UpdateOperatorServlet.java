package web.servlet.admin;
import domain.Operator;
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

@WebServlet("/updateOperatorServlet")
public class UpdateOperatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String operatorid = request.getParameter("sid");
//        session.setAttribute("sid",studentid);

        Operator operator = new Operator();
        operator.setS_id(operatorid);
        OperatorService service = new OperatorServiceImpl();
        Operator newOperator = service.findOperatorById(operator);
        request.setAttribute("operator",newOperator);

        request.getRequestDispatcher("/WEB-INF/admin/updateOperator.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
