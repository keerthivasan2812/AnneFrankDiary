package org.backend;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  implementation class DiaryView
 */
@WebServlet("/Diaryv")
public class DiaryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    private Map <String,String> diaryview;
    
    public DiaryView() {
        super();
        diaryview = new LinkedHashMap<>();
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
		String d=null;
		String e=null;
		
		
			
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","keerthi");
				String sql="select DIARYDATE,DIARYENTRY from diaryentry1";
				PreparedStatement ps = con.prepareStatement(sql);
								
				ResultSet rs = ps.executeQuery();
				 diaryview.clear();
				while (rs.next()) {
					
					 d = rs.getString("DIARYDATE");
					 
					 e = rs.getString("DIARYENTRY");
					 
					 
					 diaryview.put(d, e);
					 
					
				}
				
				
				
				    
				    
				       
				
			} catch (ClassNotFoundException | SQLException y) {
				// TODO Auto-generated catch block
				y.printStackTrace();
			}
			
			
			
			
			finally {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
//			String selectedDiaryDate = request.getParameter("date");
//	        String diaryEntry = diaryview.get(selectedDiaryDate);
//
//	        // Set content type and character encoding for response
//	        response.setContentType("text/plain");
//	        response.setCharacterEncoding("UTF-8");
//
//	        // Write the diary entry text to the response output
//	        if (diaryEntry != null) {
//	            response.getWriter().write(diaryEntry);
//	        } else {
//	            response.getWriter().write("Diary entry not found for the selected date.");
//	        }

			request.setAttribute("diaryview", diaryview);
			
			request.getRequestDispatcher("DiaryView.jsp").forward(request, response);
		
		
		
		
		
		
		
		
				 }    
}

