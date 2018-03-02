package servelet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import java.sql.*;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      // UserTable user=new UserTable();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sql ="select password from usertable where username='"+username+"'";
		 System.out.println(sql);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/yxx_film?useSSL=false","root","root");
				Statement stmt=conn.createStatement();
				System.out.println(11112);
				ResultSet rs = stmt.executeQuery(sql);
				//boolean r=stmt.execute(sql);
				System.out.println(113);
				//System.out.println(rs.next());
				if(rs.equals(null)) System.out.println("ffffff");
				
				if(rs.next())
				{   System.out.println(rs.toString());
					System.out.println(11113);
					HttpSession session=request.getSession();
                	session.setAttribute("login", "yes");
                	session.setAttribute("username", username);
	                String password1 = rs.getString("password");
	                if(password.equals(password1)) {
	                	RequestDispatcher view=request.getRequestDispatcher("film.jsp?round=1");
	                	System.out.println(1111);
	      			    view.forward(request, response);
	                }else {
	                	PrintWriter out=response.getWriter();
	            		out.println("<a href=\"http://localhost:8080/File/login.html\">fail,password is not right</a>");
	                }
	    
	            }
				
				stmt.close();
				conn.close();
				
			   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		if(name.equals("dog")) out.println("鐧婚檰鎴愬姛");
		else out.print("娌℃湁浣犺繖涓汉");
	}

}
