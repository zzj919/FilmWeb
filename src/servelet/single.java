package servelet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.*;
/**
 * Servlet implementation class single
 */
@WebServlet("/single")
public class single extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public single() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/yxx_film","root","root");
				Statement stmt=conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from filmtable where id="+id);
			
				if(rs.next()){
	                // 閫氳繃瀛楁妫�绱�
					Filmtable temp=new Filmtable();
					temp.setId(rs.getString(1));
					temp.setFilename(rs.getString(2));
					temp.setFilmtype(rs.getString(3));
					temp.setDector(rs.getString(4));
					temp.setActor(rs.getString(5));
					temp.setYear(rs.getString(6));
					temp.setIntroduction(rs.getString(7));
					temp.setCountry(rs.getString(8));
					temp.setImagename(rs.getString(9));
				 request.setAttribute("film",temp);
				 RequestDispatcher view=request.getRequestDispatcher("single.jsp");
				  view.forward(request, response);
		
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
		doGet(request, response);
	}

}
