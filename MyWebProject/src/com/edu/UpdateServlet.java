package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("sid"));
		String sn=request.getParameter("sname");
		
		try {
			Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			String sql="select * from student where sid="+id;
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				String update="update student set sname='"+sn+"' where sid="+id;
				int i=st.executeUpdate(update);
				if(i>0) {
					out.println("Record is Updated");
				}
			}
			else {
				out.println("Enter valid Id");
			}
		}catch(Exception e) {
			e.printStackTrace();
	}
	}

}
