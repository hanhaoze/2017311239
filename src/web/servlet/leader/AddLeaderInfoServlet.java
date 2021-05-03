package web.servlet.leader;

import domain.Leader;
import service.LeaderService;
import service.impl.LeaderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addLeaderInfoServlet")
public class AddLeaderInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        LeaderService service= new LeaderServiceImpl();
        //先进行判断是否已存在该教师
        String tid = request.getParameter("leader-id");
        Leader t = new Leader();
        t.setT_id(tid);
        Leader newLeader = service.findLeaderById(t);
        if (newLeader != null) {
            request.setAttribute("update_msg","已存在该督导，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addLeaderServlet").forward(request, response);
        }else {
            String name = request.getParameter("leader-name");
            String sex = request.getParameter("leader-sex");
            String postion = request.getParameter("leader-postion");
            String email = request.getParameter("leader-email");



            Leader updateLeader = new Leader();

            updateLeader.setT_id(tid);
            updateLeader.setT_name(name);
            updateLeader.setT_sex(sex);
            updateLeader.setT_postion(postion);
            updateLeader.setT_email(email);


            service.addLeaderAllInfo(updateLeader);
            request.setAttribute("update_msg", "添加成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("addLeaderServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
