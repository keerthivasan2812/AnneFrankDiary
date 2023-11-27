package org.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Connection con=null;
		  String selectedDate = request.getParameter("date");
	        String diaryEntry = request.getParameter("diary");
	        java.sql.Date selectedSqlDate = null;
	        try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","keerthi");

		        if (selectedDate != null && diaryEntry != null && !diaryEntry.isEmpty()) {
		        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		            java.util.Date utilDate = dateFormat.parse(selectedDate);
		            selectedSqlDate = new java.sql.Date(utilDate.getTime());
		            
		                String sql1 = "UPDATE diaryentry1 SET DIARYENTRY = ? WHERE DIARYDATE = ?";
		                PreparedStatement ps1 = con.prepareStatement(sql1);
		                ps1.setString(1, diaryEntry);
		                ps1.setDate(2, selectedSqlDate);

		                ps1.executeUpdate();
		        }
		       
			} catch (ClassNotFoundException | ParseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
