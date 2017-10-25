package Konwerter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet("/KonwerterKg")
public class KonwerterKg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Konwerter konwerter = new Konwerter();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        try {
            String kilogramy = request.getParameter("kilogramy");
            double kg = Double.parseDouble(kilogramy);

            writer.println(kg+" kg to " +konwerter.KgToG(kg)+" gramow.");
            writer.println(kg+" kg to " +konwerter.KgToMg(kg)+" miligramow.");

/*          writer.printf(Locale.FRANCE,"%.1f %s %.1f %s",kg,"kg to " ,konwerter.KgToG(kg)," gramow.");
            writer.printf(Locale.FRANCE,"%.1f %s %,10f %s",kg,"kg to " ,konwerter.KgToMg(kg)," miligramow.");*/
        } catch (NumberFormatException exp) {
            writer.println("Nalezy podac wartosc liczbowa");
        } finally {
            writer.close();
        }
    }
}