package web.servlet.leader;
import domain.Leader;
import domain.Line;
import service.LineService;
import service.impl.LineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addOptionalLineServlet")
public class AddOptionalLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Leader leader = (Leader) session.getAttribute("leader");

        String cid = request.getParameter("cid");
        String cname = request.getParameter("line-name");
        String cinfo = request.getParameter("line-info");

        LineService service = new LineServiceImpl();
        Line line =  service.findSelectLineByLineId(cid);
        if (line != null) {
            request.setAttribute("update_msg","线体ID冲突，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/leader/addOptionalLine.jsp").forward(request,response);
        }else {
            Line newLine = new Line();
            newLine.setC_id(cid);
            newLine.setC_name(cname);
            newLine.setC_info(cinfo);
            newLine.setT_id(leader.getT_id());
            newLine.setT_name(leader.getT_name());

            service.addOptionalLine(newLine);
            request.setAttribute("update_msg","线体添加成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/leader/addOptionalLine.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
