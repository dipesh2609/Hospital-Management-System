package hospi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospi.bo.doctor;
import hospi.dao.Hospi_dao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public SignupController() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("pass");
		
		doctor dc=new doctor();		
		dc.setName(name);
		dc.setEmail(email);
		dc.setPhone(phone);
		dc.setPass(pwd);
		
		int status=Hospi_dao.signup(dc);
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
			//pw.print("YOU ARE DONE WITH SIGNUP!!");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request, response);
			//pw.print("SOMETHING WENT WRONG!!");
		}
	}

}
