package Konwerter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.DoubleBinaryOperator;

@WebServlet("/konwerterMetrow")
public class KonwerterMetrow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Konwerter konwerter = new Konwerter();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        try {
            String metry = request.getParameter("metry");
            double m = Double.parseDouble(metry);
            writer.println(m + " m to " + konwerter.MtoCM(m) + " cm.");
            writer.println(m + " m to " + konwerter.MtoMM(m) + " mm.");
        } catch (NumberFormatException exc) {
            writer.println("Nalezy podac wartosc liczbowa");
        } finally {
            writer.close();
        }
    }
}

