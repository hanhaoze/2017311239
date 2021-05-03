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

@WebServlet("/updateLeaderInfoServlet")
public class UpdateLeaderInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String tid = request.getParameter("leader-id");

        String name = request.getParameter("leader-name");
        String sex = request.getParameter("leader-sex");
        String postion = request.getParameter("leader-postion");
        String email = request.getParameter("leader-email");

        Leader updateLeader = new Leader();
        //判断输入位数是否大于数据库位数
        if (name.length() > 4 || postion.length() > 20 || email.length()>24 || name.contains("<") || postion.contains("<") || email.contains("<")) {
            request.setAttribute("update_msg","格式错误，请重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateLeaderServlet?tid="+tid).forward(request, response);
        }else {
            //封装教师对象
            updateLeader.setT_id(tid);
            updateLeader.setT_name(name);
            updateLeader.setT_sex(sex);
            updateLeader.setT_postion(postion);
            updateLeader.setT_email(email);

            //调用TeacherUpdate服务
            LeaderService service = new LeaderServiceImpl();
            service.updateInfo(updateLeader);

            //成功则返回并给提示
            request.setAttribute("update_msg", "修改成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("updateLeaderServlet?tid=" + tid).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
