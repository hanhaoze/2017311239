package web.servlet.leader;

import domain.Admin;
import domain.Leader;
import domain.Operator;
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

@WebServlet("/leaderListServlet")
public class LeaderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用TeacherService完成查询
        LeaderService leaderService = new LeaderServiceImpl();
        List<Leader> leaders = leaderService.findAll();
        //将list存入request域
        request.setAttribute("leaders",leaders);

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Operator operator= (Operator) session.getAttribute("operator");
        Admin admin= (Admin)session.getAttribute("admin");
        Leader leader= (Leader) session.getAttribute("leader");
        if (operator != null && admin == null && leader == null) {
            request.getRequestDispatcher("/WEB-INF/operator/oFindLeaderList.jsp").forward(request, response);
        } else if (admin != null && operator == null && leader == null) {
            request.getRequestDispatcher("/WEB-INF/admin/aFindTeacherList.jsp").forward(request, response);
        } else if (leader != null && admin == null && operator == null) {
            request.getRequestDispatcher("/WEB-INF/leader/lFindLeaderList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
