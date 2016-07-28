package kr.seoul.amc.lggm.gccm.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.researchaware.core.MySQLConnector;

public class AtlasExpression {
	Properties p = new Properties(); 
	public AtlasExpression() { 
		
		
	}
	public HashMap<String, List<Properties>> GetExpression(String UniprotID) { 
		Connection  connection = MySQLConnector.ConnectToAMCLGGMServer(); 
		Statement stm;
		HashMap<String, List<Properties>> expressions = new HashMap<>(); 
		List<String> expressionsList = new ArrayList<String>(); 
		try {
			stm = connection.createStatement();
			String sql = "SELECT * FROM ALTAS_UP_MAPPINGS WHERE `UNIPROT_AC` = '"+UniprotID+"'"; 
			System.out.println(sql); 
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) { 
				//System.out.println("HELLO WORLD"); 
				expressionsList.add(rs.getString("ALTAS_MAPPING_ID")); 
			}
			rs.close(); 
			System.out.println(expressionsList.size());
			
			for(int i = 0; i<expressionsList.size(); i++) { 
				List<Properties> expariments = new ArrayList<>(); 
				sql = "SELECT * FROM AT_EXPRESSION WHERE UP_AC = '"+expressionsList.get(i)+"'"; 
				System.out.println(sql); 
				rs = stm.executeQuery(sql); 
				while(rs.next()) { 
					Properties expariment = new Properties();
					expariment.setProperty("P_VALUE", rs.getString("P_VALUE")); 
					expariment.setProperty("T_STAT", rs.getString("T_STATS")); 
					expariment.setProperty("LABEL", rs.getString("LABEL")); 
					expariments.add(expariment); 
				}
				expressions.put(expressionsList.get(i), expariments); 
				rs.close(); 
			}
			stm.close(); 
			connection.close();
			return expressions; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null; 
			
		} 
		
	}
}

