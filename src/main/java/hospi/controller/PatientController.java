package hospi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hospi.bo.Patient_bo;
import hospi.dao.Hospi_dao;


@WebServlet("/PatientController")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PatientController() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String age=request.getParameter("age");
		String appoint=request.getParameter("tr");
		String report=request.getParameter("report");
		
	//	pw.print(name+" "+email+" "+phone+" "+doj+" "+dob);
		Patient_bo pt=new Patient_bo(name, gender, phone, age, appoint, report);
		
		int status=Hospi_dao.AddPatient(pt);
		if(status>0) {
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
			
		//	pw.print("Your data has been succefully added");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("AddPatient.html");
			rd.include(request, response);
			//pw.print("Something went wrong");
		}
	}

}
