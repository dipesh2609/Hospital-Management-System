package hospi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospi.bo.Patient_bo;
import hospi.dao.Hospi_dao;


@WebServlet("/AllPatientController")
public class AllPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AllPatientController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			
			pw.print("<link rel='stylesheet' href='css/table.css'>");
			pw.print("<a href='home.html'>Back</a>");
			pw.print("<table border='1px' width='100%' table-color:'yellow' > ");
			
			pw.print("<tr> <th> Id </th> <th> Name </th> <th> Gender </th> <th> Phone </th> <th> Age </th><th> Date of Appointment </th><th> Report </th><th>Actions</th><th>Delete</th></tr>");
			
			List<Patient_bo> list = Hospi_dao.getAllPatient();
			
			for(Patient_bo pt: list)
			{
				pw.print("<tr><td>"+pt.getId()+"</td><td>"+pt.getName()+"</td><td>"+pt.getGender()+"</td><td>"+pt.getPhone()+"</td><td>"+pt.getAge()+"</td><td>"+pt.getTr()+"</td><td>"+pt.getReport()+"</td><td>" +"<a href='EditServlet2?id="+pt.getId()+"'>edit</a></td><td>"
				   		+ "<a href='DeleteServlet?id="+pt.getId()+" '>delete</a></td></tr>");
			}
			
			pw.print("</table>");
	}

}
