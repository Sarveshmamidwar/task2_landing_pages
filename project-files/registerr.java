package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/regform")
public class registerr extends HttpServlet {
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String myname =request.getParameter("name1");
		String myemail =request.getParameter("email1");
		String mycontact =request.getParameter("conc1");
		String mycollege =request.getParameter("college1");
		String mybranch =request.getParameter("branch1");
		String myyear =request.getParameter("year1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo" ,"root" , "rashminehete@4702");
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
			ps.setString(1,myname);
			ps.setString(2,myemail);
			ps.setString(3,mycontact);
			ps.setString(4,mycollege);
			ps.setString(5,mybranch);
			ps.setString(6,myyear);
			
			int count =ps.executeUpdate();
			if(count>0)
			{
				response.setContentType("text/html");
				
				out.print("<h3 style ='color:green'> Successfullllllllllllllllllllllllll</h3> ");
			
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
				
			}
			else
			{
				response.setContentType("text/html");
								out.print("<h3 style ='color:red'> got errorrrrrrrrrrrrrrrrr</h3> ");
			
				
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}
}
