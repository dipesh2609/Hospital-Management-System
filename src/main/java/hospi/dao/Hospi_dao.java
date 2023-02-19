package hospi.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospi.bo.Patient_bo;
import hospi.bo.doctor;

public class Hospi_dao 
{
		public static Connection getConnection()    //connectionProvider
		{
			Connection con = null;
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement","root","Dipesh@2609");
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			return con;
		}
		
		public static int signup(doctor dc)       //signup
		{
			int status  = 0;		
			try 
			{
					Connection con = Hospi_dao.getConnection();
					String q="insert into signup(name,email,phone,password) values(?,?,?,?)";
					
					PreparedStatement ps = con.prepareStatement(q);
					ps.setString(1, dc.getName());
					ps.setString(2, dc.getEmail());
					ps.setString(3, dc.getPhone());
					ps.setString(4, dc.getPass());
					
					status = ps.executeUpdate();
					
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			return status;
		}
		
		public static boolean userLogin(String email , String pass)  //userLogin
		{
				boolean status = false;
				try {
					Connection con=Hospi_dao.getConnection();
					String sql="select * from signup where email=? And password=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, email);
					ps.setString(2, pass);
					
					ResultSet rs=ps.executeQuery();
					status=rs.next();
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				return status;
		}
		
		public static int AddPatient(Patient_bo pt)   // add patient
		{
				int status = 0;
				
				try 
				{
					Connection con = Hospi_dao.getConnection();
					String query="insert into addpatient(name , gender , phone , age , tr ,report ) values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, pt.getName());
					ps.setString(2, pt.getGender());
					ps.setString(3, pt.getPhone());
					ps.setString(4, pt.getAge());
					ps.setString(5, pt.getTr());
					ps.setString(6, pt.getReport());
					status =ps.executeUpdate();
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				return status;
		}
		
		public static List getAllPatient()    //getALlPatient
		{
			List zx=new ArrayList();
			
			try 
			{
				Connection con=Hospi_dao.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from addpatient");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) 
				{
					Patient_bo pt=new Patient_bo();
					pt.setId(rs.getInt(1));
					pt.setName(rs.getString(2));
					pt.setGender(rs.getString(3));
					pt.setPhone(rs.getString(4));
					pt.setAge(rs.getString(5));
					pt.setTr(rs.getString(6));
					pt.setReport(rs.getString(7));
					
					zx.add(pt);
				}
			} catch (Exception e) 
			{
				System.out.println(e);
			}
			
			return zx;
		}
		
		public static Patient_bo getPatientById(int id)   
		{
				Patient_bo pt = new Patient_bo();
				
				try 
				{
					Connection con=Hospi_dao.getConnection();
					String q = "Select * from addpatient  where id=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, id);
					
					ResultSet rs=ps.executeQuery();
					if(rs.next()) 
					{
						
						pt.setId(rs.getInt(1));
						pt.setName(rs.getString(2));
						pt.setGender(rs.getString(3));
						pt.setPhone(rs.getString(4));
						pt.setAge(rs.getString(5));
						pt.setTr(rs.getString(6));
						pt.setReport(rs.getString(7));
						
					}
				} catch (Exception e) 
				{
					
				}
				return pt;
		}
		
		public static int Update(Patient_bo pt)
		{
				int status = 0;
				try 
				{
					Connection con = Hospi_dao.getConnection();
					String q = "UPDATE addpatient SET name=? , gender=? , phone=? , age = ? , tr = ? , report = ? where id = ?";
					PreparedStatement ps = con.prepareStatement(q);
					
					ps.setString(1, pt.getName());
					ps.setString(2, pt.getGender());
					ps.setString(3, pt.getPhone());
					ps.setString(4, pt.getAge());
					ps.setString(5, pt.getTr());
					ps.setString(6, pt.getReport());
					
					ps.setInt(7, pt.getId());
					
					status = ps.executeUpdate();
							
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				return status;
		}
		
		public static int delete(int id)            //delete
		{
				int status =0 ;
				
				try 
				{
					  Connection con=Hospi_dao.getConnection();
					  String query="Delete from addpatient where id=?";
					  PreparedStatement ps=con.prepareStatement(query);
					  ps.setInt(1, id);
					  status=ps.executeUpdate();
				} catch (Exception e) {
					
				}
				
				return status;
		}
}
