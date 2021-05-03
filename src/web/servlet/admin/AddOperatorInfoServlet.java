package web.servlet.admin;
import domain.Operator;
import service.OperatorService;
import service.impl.OperatorServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addOperatorInfoServlet")
public class AddOperatorInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        OperatorService service= new OperatorServiceImpl();
        //先进行判断是否已存在该学生
        String sid = request.getParameter("operator-id");
        Operator s = new Operator();
        s.setS_id(sid);
        Operator newOperator = service.findOperatorById(s);
        if (newOperator != null) {
            request.setAttribute("update_msg","已存在该学生，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addOperatorServlet").forward(request, response);
        }else {
            String name = request.getParameter("operator-name");
            String sex = request.getParameter("operator-sex");
            String age = request.getParameter("operator-age");
            String phone = request.getParameter("operator-phone");
            String email = request.getParameter("operator-email");
            String address = request.getParameter("operator-address");


            Operator updateOperator = new Operator();

            updateOperator.setS_id(sid);
            updateOperator.setS_name(name);
            updateOperator.setS_sex(sex);
            updateOperator.setS_age(age);
            updateOperator.setS_phone(phone);
            updateOperator.setS_email(email);
            updateOperator.setS_address(address);

            service.addOperatorAllInfo(updateOperator);
            request.setAttribute("update_msg","添加成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addOperatorServlet").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
