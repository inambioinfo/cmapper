package kr.seoul.amc.lggm.gccm.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.seoul.amc.lggm.gccm.core.GeneSearchFactory;

/**
 * Servlet implementation class GeneSearch
 */
@WebServlet("/GeneSearch")
public class GeneSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter(); 
		String geneID = request.getParameter("genesList"); 
		String dbsString = request.getParameter("databases"); 
		String output = request.getParameter("output"); 
		String graphType = request.getParameter("graphType"); 
		String inputType = request.getParameter("inputType"); 
		
		                                                
		Map<String, String[]> perms = request.getParameterMap();
		
		
		String fileName = geneID.replace(";", "-"); 
		
		
		String[] databases = dbsString.split(";"); 
		if(geneID == "") { 
			writer.write("NO INPUT GIVEN");
			return; 
		}
		
		if(perms.containsKey("graphOption")) {
			if(perms.get("graphOption")[0].equals("json")){ 
				response.setContentType("application/json");
				fileName = fileName + ".json"; 
			}
			else if(perms.get("graphOption")[0].equals("csv")){ 
				response.setContentType("text/plain");
				fileName = fileName + ".csv"; 
			}
			else {
				fileName = fileName + ".graphml"; 
			}
			
		} else {
			fileName = fileName + ".graphml"; 
		}

		
		if(output.equals("ViewGraph") == false) { 
			response.setContentType("application/force-download");
			
			response.setHeader("Content-Disposition","attachment; filename=\"" +fileName + "\"");//fileName);
		} else { 
			response.setContentType("text/plain");
		}
		
		ServletContext context = getServletContext(); 
		GeneSearchFactory gsf = new GeneSearchFactory(context); 
		writer.println(gsf.GetGeneGraphML(inputType, geneID, dbsString, graphType, perms));
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
