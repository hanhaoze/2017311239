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

@WebServlet("/operatorInformationUpdateServlet")
public class OperatorInformationUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //保存输入内容
        String sid = request.getParameter("operator-id");
        String name = request.getParameter("operator-name");
        String sex = request.getParameter("operator-sex");
        String age = request.getParameter("operator-age");
        String phone = request.getParameter("operator-phone");
        String email = request.getParameter("operator-email");
        String address = request.getParameter("operator-address");

        Operator updateOperator = new Operator();


        //判断输入位数是否大于数据库位数
        if (name.length() > 4 || phone.length() > 11 || email.length()>24 || address.length() > 24 || age.length()>2 || name.contains("<") || phone.contains("<") || email.contains("<") || address.contains("<") || age.contains("<")) {
            request.setAttribute("update_msg","格式错误，请重新提交！"+String.format("%tT",new Date()));

            request.getRequestDispatcher("/WEB-INF/operator/oInformation.jsp").forward(request, response);
//            response.sendRedirect("studentInfomationServlet");
        }else {
            //封装学生对象
            updateOperator.setS_id(sid);
            updateOperator.setS_name(name);
            updateOperator.setS_sex(sex);
            updateOperator.setS_age(age);
            updateOperator.setS_phone(phone);
            updateOperator.setS_email(email);
            updateOperator.setS_address(address);

            //调用operatorUpdata服务
            OperatorService service= new OperatorServiceImpl();
            service.updateInfo(updateOperator);

            HttpSession session = request.getSession();

            Operator o = service.findOperatorById(updateOperator);
            session.setAttribute("operator",o);

            //成功则返回并给提示
            request.setAttribute("update_msg", "修改成功！"+String.format("%tT",new Date()));
            request.setAttribute("operator",updateOperator);
            request.getRequestDispatcher("/WEB-INF/operator/oInformation.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
