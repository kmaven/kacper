import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Kacper on 2016-12-01.
 */

public class addOneProcess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marka=request.getParameter("marka");
        String model=request.getParameter("model");
        String rocznik=request.getParameter("rocznik");
        int rok=Integer.parseInt(rocznik);
        String pojemnosc=request.getParameter("pojemnosc");
        float poj=Float.parseFloat(pojemnosc);

        System.out.println(marka);
        System.out.println(model);

        Car nowy=new Car(marka,model,rok,poj);
        nowy.insertCar();

        request.getSession().setAttribute("marka",marka);
        request.getSession().setAttribute("model",model);
        request.getSession().setAttribute("rocznik",rocznik);
        request.getSession().setAttribute("pojemnosc",pojemnosc);

        response.sendRedirect("printout.jsp");


    }
}
