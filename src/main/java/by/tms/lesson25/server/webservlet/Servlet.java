package by.tms.lesson25.server.webservlet;

import by.tms.lesson25.server.model.Operation;
import by.tms.lesson25.server.service.OperationService;
import by.tms.lesson25.server.storage.InMemoryOperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class Servlet extends HttpServlet {
    OperationService operationService = new OperationService();
    private static final InMemoryOperationStorage storage = new InMemoryOperationStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        Operation operation = new Operation();
        operation.setNum1(num1);
        operation.setNum2(num2);
        operation.setType(type);

        Operation calculate = operationService.calculate(operation);
        storage.save(operation);

        String result = String.valueOf(calculate.getResult());


        resp.getWriter().print(storage.findAll());
        resp.getWriter().print(String.format("Result = %s", result));



    }
}
