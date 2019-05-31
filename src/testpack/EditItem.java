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
 * Servlet implementation class EditItem
 */
@WebServlet("/EditItem")
public class EditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DB_Access db = new DB_Access();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new java.util.Date();
		request.getSession().setAttribute("date", date);
		
		String id = "";
		
		if (request.getSession().getAttribute("id") != null) {
			id = (String) request.getSession().getAttribute("id");
		}
		else {
			id = request.getParameter("id");
		}
		System.out.println("Current ID is: " + id);
		
		Item item = db.getSingleUserItem(id);
		
		request.getSession().setAttribute("item", item);
		request.getSession().setAttribute("id", id);


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/edititem.jsp");
		rd.forward(request, response);		
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iid = (String) request.getSession().getAttribute("id");
		String iname = request.getParameter("iname");
		String iqty = request.getParameter("iqty");
		
		System.out.println("Edit Item do Post ---- IID: "+iid+ " INAME: " + iname + " IQTY: " + iqty);
		
		String msg = db.modifyItem(iid, iname, iqty);
		
//		request.getSession().removeAttribute("id");
		response.sendRedirect("EditItem?msg="+msg);
		
	}

}
