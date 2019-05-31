package testpack;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")

public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new java.util.Date();
		request.getSession().setAttribute("date", date);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname = request.getParameter("lname");
		String lpass = request.getParameter("lpass");
		DB_Access db = new DB_Access();
		int uid = db.validateLogin(lname, lpass);
		if(uid == -1) {
			// invalid login attempt
			response.sendRedirect("Login?msg=either name or pass or both are wrong...");
		}
		else {
			// valid login attempt
			request.getSession().setAttribute("uid", uid);
			response.sendRedirect("Home");
		}
	}
}
