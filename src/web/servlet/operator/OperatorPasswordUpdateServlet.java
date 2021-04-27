package web.servlet.operator;

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
import java.util.Date;

@WebServlet("/operatorPasswordUpdateServlet")
public class OperatorPasswordUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Operator operator= (Operator) session.getAttribute("operator");

        String operatorid = operator.getS_id();
        String newpassword = request.getParameter("operator-newpassword");
        String ennewpassword = request.getParameter("operator-ennewpassword");
        String regex = "^[\\w]{3,12}$";
        boolean flag = newpassword.matches(regex);
        if (!flag) {
            request.setAttribute("update_msg", "密码格式错误，重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/operator/operatorUpdatePassword.jsp").forward(request, response);
        } else if (!newpassword.equals(ennewpassword)) {
            request.setAttribute("update_msg", "密码确认错误，请重新提交！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/operator/operatorUpdatePassword.jsp").forward(request, response);
        } else {

            OperatorService service= new OperatorServiceImpl();
            service.updatePassword(operatorid,newpassword);

            Operator newOperator = service.findOperatorById(operator);
            operator = newOperator;
            session.setAttribute("operator",operator);

            request.setAttribute("update_msg", "修改成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/operator/operatorUpdatePassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
