package testpack;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new java.util.Date();
		request.getSession().setAttribute("date", date);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/additem.jsp");
		rd.forward(request, response);	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Access db = new DB_Access();
		
		String iname = request.getParameter("iname");
		String iqty = request.getParameter("iqty");
		int uid = (int) request.getSession().getAttribute("uid");
		
		int result = db.addItem(iname, iqty, uid);
		
		
		
		String redirectURL = "";
		if (result == 0) {
			redirectURL = "Home?msg=Item successfully added";
			request.getSession().removeAttribute("iname");
			request.getSession().removeAttribute("iqty");
		}
		else { 
			request.getSession().setAttribute("iname", iname);
			request.getSession().setAttribute("iqty", iqty);
			if (result == 1) {
				redirectURL = "AddItem?msg=Improper name";
			}
			else {
				redirectURL = "AddItem?msg=Improper quantity";
			}
		}
		
		response.sendRedirect(redirectURL);
		
	}

}
