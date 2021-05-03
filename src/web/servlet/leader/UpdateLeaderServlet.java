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
import java.util.List;

@WebServlet("/updateLeaderServlet")
public class UpdateLeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String leaderid = request.getParameter("tid");

        Leader leader = new Leader();
        leader.setT_id(leaderid);
        LeaderService service = new LeaderServiceImpl();
        Leader newLeader = service.findLeaderById(leader);
        request.setAttribute("leader",newLeader);

        request.getRequestDispatcher("/WEB-INF/admin/updateLeader.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
