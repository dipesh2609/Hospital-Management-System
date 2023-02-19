package hospi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospi.bo.Patient_bo;
import hospi.dao.Hospi_dao;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditServlet2() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		pw.print("<link rel='stylesheet' href='css/edit.css'>");
		
		String id=request.getParameter("id");
		
		int mid=Integer.parseInt(id);
	      
		Patient_bo pt=Hospi_dao.getPatientById(mid);
		pw.print("<html>");
		pw.print("<body style='text-align:center'>");
		
		pw.print("<form action='UpdateController' method='Get'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' id='na' value='"+pt.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td><td><input type='text' name='name' id='na' value='"+pt.getName()+"'/></td></tr>"); 
		pw.print("<tr><td>Gender: </td><td><input type='text' name='gender' id='na' value='"+pt.getGender()+"'/></td></tr>"); 
		pw.print("<tr><td>Phone: </td><td><input type='text' name='phone' id='na' value='"+pt.getPhone()+"'/></td></tr>"); 
		pw.print("<tr><td>Age: </td><td><input type='text' name='age' id='na' value='"+pt.getAge()+"'/></td></tr>"); 
		pw.print("<tr><td>Date of Appointment: </td><td><input type='text' name='tr' id='na' value='"+pt.getTr()+"'/></td></tr>"); 
		pw.print("<tr><td>Report: </td><td><input type='text' name='report' id='na' value='"+pt.getReport()+"'/></td></tr>"); 
	    
		pw.print("<tr><td><input type='submit' id='btn' value='Update'/> </td></tr>");
		
		pw.print("</table>");
		pw.print("</form>");
		pw.print("</body>");
		pw.print("</html>");
	}

}
