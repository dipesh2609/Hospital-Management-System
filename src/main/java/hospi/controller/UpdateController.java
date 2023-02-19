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

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public UpdateController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		response.getWriter().append("Served at: ").append(request.getContextPath());
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();

			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("phone");
			String age=request.getParameter("age");
			String appoint=request.getParameter("tr");
			String report=request.getParameter("report");
			
			Patient_bo pt = new Patient_bo();
			pt.setId(id);
			pt.setName(name);
			pt.setGender(gender);
			pt.setPhone(phone);
			pt.setAge(age);
			pt.setTr(appoint);
			pt.setReport(report);
			
			int status=Hospi_dao.Update(pt);
			
			if(status>0) {
				RequestDispatcher rd=request.getRequestDispatcher("AllPatientController");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("EditServlet2");
				rd.include(request, response);
			}
	}

}
