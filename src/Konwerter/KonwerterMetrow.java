package Konwerter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.function.DoubleBinaryOperator;

@WebServlet("/konwerterMetrow")
public class KonwerterMetrow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Konwerter konwerter = new Konwerter();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        DecimalFormat df = new DecimalFormat("###,###,###.0");

        try {
            String metry = request.getParameter("metry");
            double m = Double.parseDouble(metry);
            writer.println(df.format(m) + " m to " + df.format(konwerter.MtoCM(m)) + " cm.</br>");
            writer.println(df.format(m)  + " m to " + df.format(konwerter.MtoMM(m)) + " mm.</br>");
        } catch (NumberFormatException exc) {
            writer.println("Nalezy podac wartosc liczbowa");
        } finally {
            writer.close();
        }
    }
}

