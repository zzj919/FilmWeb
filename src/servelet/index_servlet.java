package servelet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.*;
import dao.index_dao;

/**
 * Servlet implementation class index_servlet
 */
@WebServlet("/index_servlet")
public class index_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String round=request.getParameter("round");

		
		int round_int= Integer.parseInt(round);
		index_dao temp=new index_dao();
		temp.getbaseflim(round_int);
		ArrayList<Filmtable> film=temp.getBase();
		for(int i=0;i<film.size();i++) {
			Filmtable t=(Filmtable)film.get(i);

			System.out.println(t.getFilename());
		}
		request.setAttribute("film",film);
		 RequestDispatcher view=request.getRequestDispatcher("film.jsp");
		  view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
