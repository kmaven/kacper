import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;


public class viewTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding( "UTF-8" );
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        ArrayList<Car> cars = Car.getCars();
        request.setAttribute("cars", cars);


        try(PrintWriter writer = response.getWriter()){
        for (Car car : cars){
            String out="Marka: "+car.getMarka()+"\tModel: "+car.getModel()+"\tPojemnosc: "+car.getPojemnosc()+"\tRocznik: "+car.getRocznik()+"<br>";
            writer.println(out);
        }
        }
    }
}
