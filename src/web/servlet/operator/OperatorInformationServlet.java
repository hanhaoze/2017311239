package web.servlet.operator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/operatorInformationServlet")
public class OperatorInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //       HttpSession session = request.getSession();
//        Student s = (Student) session.getAttribute("student");
//        StudentService service = new StudentServiceImpl();
//        Student newStudent = service.findStudentById(s);
//        session.setAttribute("student",newStudent);
        request.getRequestDispatcher("/WEB-INF/operator/oInformation.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
