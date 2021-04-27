package web.servlet.login;

import domain.Operator;
import domain.Operator;
import service.OperatorService;
import service.OperatorService;
import service.impl.OperatorServiceImpl;
import service.impl.OperatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String operatorid = request.getParameter("operatorid");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String vcode = request.getParameter("verifycode");

        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证一次性
        if (!vcode.equalsIgnoreCase(checkcode_server)){
            request.setAttribute("msg","验证码错误");
            request.setAttribute("operator",operatorid);
            request.setAttribute("password",password);
            request.setAttribute("repassword",repassword);
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }else {
            Operator operator = new Operator();
            operator.setS_id(operatorid);
            operator.setS_password(password);
            System.out.println(operatorid);
            System.out.println(password);
            OperatorService service= new OperatorServiceImpl();
            service.register(operator);
            request.setAttribute("msg","注册成功");
            request.setAttribute("operatorid","");
            request.setAttribute("password","");
            request.setAttribute("repassword","");
            request.getRequestDispatcher("register.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
