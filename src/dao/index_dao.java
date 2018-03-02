package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import domain.*;
import tools.*;

import javax.servlet.RequestDispatcher;

public class index_dao {
     public ArrayList<Filmtable> base=new ArrayList<Filmtable>(100);
     public ArrayList<Filmtable> Re=new ArrayList<Filmtable>(100);
       
	
	
       public ArrayList<Filmtable> getBase() {
		return base;
	}
	public void setBase(ArrayList<Filmtable> base) {
		this.base = base;
	}
	public ArrayList<Filmtable> getRe() {
		return Re;
	}
	public void setRe(ArrayList<Filmtable> re) {
		Re = re;
	}
	//获取基本数据库电影
	public void getbaseflim(int round) {
		int begin=(round-1)*8+1;
		int end=7+begin;
		String sql="select * from filmtable where id between "+begin+" and "+end;
		/*ConnDB con=null;
		 con=new ConnDB();
		
		ResultSet rs = con.executeQuery(sql);
		 int i=0;
			try {
				while(rs.next()){
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
				base.add(temp);
				i++;
       }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			while(i<8) {
				Filmtable temp=new Filmtable();
				temp.setId("-1");
				temp.setFilename("null");
				temp.setFilmtype("null");
				temp.setDector("null");
				temp.setActor("null");
				temp.setYear("null");
				temp.setIntroduction("null");
				temp.setCountry("null");
				temp.setImagename("null");
				base.add(temp);
				i++;
				
			}
			con.close();*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/yxx_film","root","root");
				Statement stmt=conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			    int i=0;
				while(rs.next()){
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
				base.add(temp);
				i++;
	            }
				
				
				while(i<8) {
					Filmtable temp=new Filmtable();
					temp.setId("-1");
					temp.setFilename("null");
					temp.setFilmtype("null");
					temp.setDector("null");
					temp.setActor("null");
					temp.setYear("null");
					temp.setIntroduction("null");
					temp.setCountry("null");
					temp.setImagename("null");
					base.add(temp);
					i++;
					
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
	public void get_id_of_flim(String film_id) {
		
	}
	public void getRefilm(int userid) {
		
	}
       
}
