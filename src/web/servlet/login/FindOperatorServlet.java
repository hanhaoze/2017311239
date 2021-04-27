package web.servlet.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Operator;
import service.OperatorService;
import service.impl.OperatorServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findOperatorServlet")
public class FindOperatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String operatorId = request.getParameter("operatorid");
        Operator operator = new Operator();
        Operator findOperator= new Operator();
        operator.setS_id(operatorId);
        OperatorService service = new OperatorServiceImpl();
        findOperator = service.findOperatorById(operator);
        Map<String,Object>map = new HashMap<String,Object>();

        try {
            if (operatorId.equals(findOperator.getS_id())) {
                map.put("operatorExsit", true);
                map.put("msg", "ID已存在");
            } else {
                map.put("operatorExsit", false);
                map.put("msg", "用户名可用");
            }
            //map转为json传给客户端
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(),map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
