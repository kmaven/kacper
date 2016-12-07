

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageOneProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String add=request.getParameter("add");
		String phone=request.getParameter("phone");
		
		System.out.println("the name is: " + name);
		System.out.println("the address is: " + add);
		System.out.println("the phone is: " + phone);
		
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("add", add);
		request.getSession().setAttribute("phone", phone);
		
		response.sendRedirect("html/PageTwo.html");
		}

}
