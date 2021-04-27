package web.servlet.notify;

import domain.Leader;
import domain.Notify;
import domain.Operator;
import service.NotifyService;
import service.impl.NotifyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/notifyListToServlet")
public class NotifyListToServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NotifyService service = new NotifyServiceImpl();
        List<Notify> notifys = service.findAll();
        request.setAttribute("notifys",notifys);

        HttpSession session = request.getSession();
        Operator operator= (Operator) session.getAttribute("operator");
        Leader leader= (Leader) session.getAttribute("leader");
        if (operator != null && leader == null) {
            request.getRequestDispatcher("/WEB-INF/notify/notifyListToOperator.jsp").forward(request,response);
        } else if (leader != null && operator == null) {
            request.getRequestDispatcher("/WEB-INF/notify/notifyListToLeader.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
