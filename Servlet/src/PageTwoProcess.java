

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageTwoProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String course=request.getParameter("course");
		
		System.out.println("the ID is: " + id);
		System.out.println("the course is: " + course);
		
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("course", course);
		
		response.sendRedirect("jsp/printout.jsp");
	}

}
