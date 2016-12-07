package kaceper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kacper on 2016-12-07.
 */
public class Imie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");

        //System.out.println(imie);
        request.getSession().setAttribute("imie",imie);

        response.sendRedirect("view.jsp");
    }
}
