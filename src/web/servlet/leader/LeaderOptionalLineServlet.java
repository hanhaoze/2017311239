package web.servlet.leader;
import domain.Leader;
import domain.Line;
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

@WebServlet("/leaderOptionaLineServlet")
public class LeaderOptionalLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Leader l = (Leader) session.getAttribute("leader");
        if (l != null) {
            //调用StudentService完成查询
            LeaderService service = new LeaderServiceImpl();
            List<Line> optionallines = service.findMySelfOptionalLine(l.getT_id());
            //将list存入request域
            request.setAttribute("optionallines",optionallines);
            //转发到list.jsp
            request.getRequestDispatcher("/WEB-INF/leader/leaderOptionalLine.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
