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

@WebServlet("/updateOperatorInfoServlet")
public class UpdateOperatorInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        HttpSession session = request.getSession();
        String sid = request.getParameter("operator-id");
        System.out.println("sid:"+sid);


        //保存输入内容
        String name = request.getParameter("operator-name");
        System.out.println("sname:"+name);
        String sex = request.getParameter("operator-sex");
        System.out.println("ssex:"+sex);
        String age = request.getParameter("operator-age");
        String phone = request.getParameter("operator-phone");
        String email = request.getParameter("operator-email");
        String address = request.getParameter("operator-address");

        Operator updateOperator = new Operator();

        //判断输入位数是否大于数据库位数
        if (name.length() > 4 || phone.length() > 11 || email.length()>24 || address.length() > 24 || age.length()>2 || name.contains("<") || phone.contains("<") || email.contains("<") || address.contains("<") || age.contains("<")) {
            request.setAttribute("update_msg","格式错误，请重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateOperatorServlet?sid="+sid).forward(request, response);
        }else {
            //封装学生对象
            updateOperator.setS_id(sid);
            updateOperator.setS_name(name);
            updateOperator.setS_sex(sex);
            updateOperator.setS_age(age);
            updateOperator.setS_phone(phone);
            updateOperator.setS_email(email);
            updateOperator.setS_address(address);

            //调用studentUpdata服务
            OperatorService service= new OperatorServiceImpl();
            service.updateInfo(updateOperator);

            //成功则返回并给提示
            request.setAttribute("update_msg", "修改成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateOperatorServlet?sid="+sid).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
