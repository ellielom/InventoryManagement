package testpack;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DB_Access db = new DB_Access();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new java.util.Date();
		request.getSession().setAttribute("date", date);
		
		int uid = 0;
		if (request.getSession().getAttribute("uid") != null) {
			uid = (int) request.getSession().getAttribute("uid");
		}
		else {
			response.sendRedirect("Login?msg=Must log in first");
		}
		
		
		
		String username = db.getUserLoginName(uid);
		String password = db.getUserPassword(uid);
		String fullname = db.getUserName(uid);
		
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);
		request.getSession().setAttribute("fullname", fullname);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/editaccount.jsp");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = (int) request.getSession().getAttribute("uid");
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if (!password1.equals(password2)) {
			response.sendRedirect("EditAccount?msg=Passwords do not match, please try again");
		}
		else if (username.equals("") || fullname.equals("") || password1.equals("") || password2.equals("")) {
			response.sendRedirect("EditAccount?msg=Missing one or more fields, please try again");
		}
		else if (username.length() > 20 || fullname.length() > 20 || password1.length() > 20) {
			response.sendRedirect("EditAccount?msg=One or more fields too long, please try again");
		}
		else {
			int result = db.updateAccount(uid, username, fullname, password1);
			String msg = "";
			if (result == 0) {
				msg = "Account updated successfully";
			}
			else {
				msg = "Account not updated";
			}
			response.sendRedirect("EditAccount?msg="+msg);
		}
	}
		
}
