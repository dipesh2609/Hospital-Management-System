package hospi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospi.dao.Hospi_dao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public LoginController() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String email=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if(Hospi_dao.userLogin(email, pass)) {
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			//pw.print("You have Successfully logged In..");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			//pw.print("username or password are wrong..");;
		}
	}

}
