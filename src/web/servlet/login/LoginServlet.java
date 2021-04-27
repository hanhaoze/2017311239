package web.servlet.login;

import domain.Admin;
import domain.Leader;
import domain.Notify;
import domain.Operator;
import service.AdminService;
import service.LeaderService;
import service.NotifyService;
import service.OperatorService;
import service.impl.AdminServiceImpl;
import service.impl.LeaderServiceImpl;
import service.impl.NotifyServiceImpl;
import service.impl.OperatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Operator loginOperator = null ;
        Leader loginLeader = null ;
        Admin loginAdmin = null ;
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String verifycode = request.getParameter("verifycode");
        String loginid = request.getParameter("id");
        String loginpassword = request.getParameter("password");

        //验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证一次性
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            request.setAttribute("login_msg","验证码错误");
            //跳转页面
            request.setAttribute("loginid",loginid);
            request.setAttribute("loginpassword",loginpassword);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");

        //公告加载
        NotifyService notifyService= new NotifyServiceImpl();
        List<Notify> notifys = notifyService.find();
        session.setAttribute("notifys",notifys);

        //判断roles封装对象、保存session、调用不同Service查询
        if ("operator".equals(roles)) {

            Operator operator = new Operator();
            operator.setS_id(id);
            operator.setS_password(password);

            OperatorService service= new OperatorServiceImpl();
            loginOperator = service.login(operator);

            if (loginOperator != null) {
                session.setAttribute("operator", loginOperator);
                session.setAttribute("html_title", "操作员");
                request.getRequestDispatcher("/WEB-INF/operator/oIndex.jsp").forward(request,response);

            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.setAttribute("loginid",loginid);
                request.setAttribute("loginpassword",loginpassword);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else if ("leader".equals(roles)) {

            Leader leader = new Leader();
            leader.setT_id(id);
            leader.setT_password(password);

            LeaderService service = new LeaderServiceImpl();
            loginLeader = service.login(leader);

            if (loginLeader != null) {
                session.setAttribute("leader", loginLeader);
                session.setAttribute("html_title", "督导");
              request.getRequestDispatcher("/WEB-INF/leader/lIndex.jsp").forward(request, response);

            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        }else {

            Admin admin = new Admin();
            admin.setA_id(id);
            admin.setA_password(password);

            AdminService service = new AdminServiceImpl();
            loginAdmin = service.login(admin);

            if (loginAdmin != null) {
                session.setAttribute("admin", loginAdmin);
                session.setAttribute("html_title", "管理员");
//                request.getRequestDispatcher("/WEB-INF/admin/aIndex.jsp").forward(request,response);
                response.sendRedirect("adminIndexServlet");
            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
