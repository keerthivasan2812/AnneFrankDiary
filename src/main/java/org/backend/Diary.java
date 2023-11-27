package org.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 
 */
@WebServlet("/Diary")
public class Diary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    private List<String> diaryentry;
    
    public Diary() {
    	super();
    	diaryentry=new ArrayList<>();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String diary = request.getParameter("diary");
		String date=request.getParameter("date");
		Connection con=null;
		if (diary!=null&&!diary.isEmpty() && date != null && !date.isEmpty()) {
			diaryentry.add(diary);
			
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","keerthi");
			String sql="insert into diaryentry1(DIARYENTRY,DIARYDATE)values(?, TO_DATE(?, 'YYYY-MM-DD'))";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, diary);
			ps.setString(2, date);
			ps.executeUpdate();
		
					
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		diary="";
		}
		
		
		else {
			PrintWriter w = response.getWriter();
			w.println("it is invalid");

		}
		request.setAttribute("diary",  diary);
		
		request.getRequestDispatcher("Diary.jsp").forward(request, response);
		
	}
	
	
	
	

}
