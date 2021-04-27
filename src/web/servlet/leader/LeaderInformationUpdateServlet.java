package web.servlet.leader;

import domain.Leader;
import domain.Operator;
import service.LeaderService;
import service.OperatorService;
import service.impl.LeaderServiceImpl;
import service.impl.OperatorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/leaderInformationUpdateServlet")
public class LeaderInformationUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //保存输入内容
        String sid = request.getParameter("leader-id");
        String name = request.getParameter("leader-name");
        String sex = request.getParameter("leader-sex");
        String phone = request.getParameter("leader-phone");
        String email = request.getParameter("leader-email");
        String postion = request.getParameter("leader-postion");

        Leader updateLeader = new Leader();


        //判断输入位数是否大于数据库位数

            //封装学生对象
            updateLeader.setT_id(sid);
            updateLeader.setT_name(name);
            updateLeader.setT_sex(sex);
            updateLeader.setT_phone(phone);
            updateLeader.setT_email(email);
            updateLeader.setT_postion(postion);

            //调用operatorUpdata服务
            LeaderService service= new LeaderServiceImpl();
            service.updateInfo(updateLeader);

            HttpSession session = request.getSession();

            Leader l = service.findLeaderById(updateLeader);
            session.setAttribute("leader",l);

            //成功则返回并给提示
            request.setAttribute("update_msg", "修改成功！"+String.format("%tT",new Date()));
            request.setAttribute("leader",updateLeader);
            request.getRequestDispatcher("/WEB-INF/leader/lInformation.jsp").forward(request, response);
        }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
