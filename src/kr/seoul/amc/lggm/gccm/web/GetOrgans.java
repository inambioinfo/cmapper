package kr.seoul.amc.lggm.gccm.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.seoul.amc.lggm.gccm.core.GeneSearchFactory;
import sun.print.PrinterJobWrapper;

/**
 * Servlet implementation class GetOrgans
 */
@WebServlet("/GetOrgans")
public class GetOrgans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrgans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter(); 
		String output = ""; 
		 output = "<option value=\"allOrgans\">All Organs</option>"; 
		
		ServletContext context = getServletContext(); 
		GeneSearchFactory gsf = new GeneSearchFactory(context); 
		
		ArrayList<String> list;
		try {
			list = gsf.ReturnOrgansList();
			for(int i = 0; i<list.size(); i++) { 
				output = output + "<option value=\"" + list.get(i) + "\">" + list.get(i).toUpperCase() + "</option>\r\n";  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//System.out.println(output);
		
		writer.println(output);
	}

}
