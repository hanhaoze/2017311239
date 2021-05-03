package web.servlet.leader;

import domain.Leader;
import service.LeaderService;
import service.impl.LeaderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/leaderPasswordUpdateServlet")
public class LeaderPasswordUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Leader leader = (Leader) session.getAttribute("leader");

        String leaderid = leader.getT_id();
        String newpassword = request.getParameter("leader-newpassword");
        String ennewpassword = request.getParameter("leader-ennewpassword");
        String regex = "^[\\w]{3,12}$";
        boolean flag = newpassword.matches(regex);
        if (!flag) {
            request.setAttribute("update_msg", "密码格式错误，重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/teacherUpdatePassword.jsp").forward(request, response);
        } else if (!newpassword.equals(ennewpassword)) {
            request.setAttribute("update_msg", "密码确认错误，请重新提交！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/teacherUpdatePassword.jsp").forward(request, response);
        } else {

            LeaderService service= new LeaderServiceImpl();
            service.updatePassword(leaderid,newpassword);

            Leader newLeader = service.findLeaderById(leader);
            leader = newLeader;
            session.setAttribute("leader",leader);

            request.setAttribute("update_msg", "修改成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/leader/leaderUpdatePassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
