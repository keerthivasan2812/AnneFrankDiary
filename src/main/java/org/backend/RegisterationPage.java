package org.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterationPage
 */
@WebServlet("/RegisterationPage")
public class RegisterationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationPage() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String user = request.getParameter("user");
		String password = request.getParameter("pass");
		String confirmpassword = request.getParameter("passs");
		String diary = request.getParameter("diary");
		if (number!=null&&number.matches("\\d{10}")&&email!=null&&email.endsWith("@gmail.com")&&!user.isEmpty()&&user
				!=null&&!password.isEmpty()&&password!=null&&!confirmpassword.isEmpty()&&confirmpassword!=null &&password.equals(confirmpassword)) {
			Long number1 = Long.parseLong(number);
			
			Connection con=null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","keerthi");
				
				String sql="insert into register4   (USERNAME,PASSWORD,CONFIRMPASSWORD,EMAIL,PHONENUMBER)values(?,?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user);
				ps.setString(2, password);
				ps.setString(3, confirmpassword);
				ps.setString(4, email);
				ps.setLong(5, number1);
				
				
				ps.executeUpdate();
				 
				
				
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if (con!=null) {
						
					
					con.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		} else {
			PrintWriter success = response.getWriter();
			success.println("your enter details are not right");

		}
		
		request.setAttribute(confirmpassword, "");
		request.setAttribute(password, "");
		request.setAttribute(email, "");
		request.setAttribute(number, "");
		request.setAttribute(user, "");
		request.setAttribute(confirmpassword, "");
		
	
		request.getRequestDispatcher("LoginPage1.jsp").forward(request, response);
	}

}
