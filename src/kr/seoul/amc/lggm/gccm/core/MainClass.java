package kr.seoul.amc.lggm.gccm.core;

import java.io.FileInputStream;



import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GeneSearchFactory gsf = new GeneSearchFactory(null); 
		
		//System.out.println(gsf.GetGeneGraphML("gene", "PPP2R5A", "biomodels;", "summerized"));
		
		//gsf.GetGeneGraphML("molecule", "QUETIAPINE", "reactome;atlas;", "detailed"); 
		
		ArrayList<String> list = gsf.ReturnList("AA_", "gene"); 
		String outputHTML = ""; 
		for(int i = 0; i<list.size(); i++) { 
			outputHTML = outputHTML + "<a href=\"#\">" + list.get(i) + "</a> <br />\r\n"; 
		}
		System.out.println(outputHTML);
		
		//Node n = new Node("mynode"); 
		/*
		Model model = ModelFactory.createMemModelMaker().createDefaultModel();
		try {
			model.read(new FileInputStream("files/P0C9I5.rdf"), 
					"http://purl.uniprot.org/core/");
			StmtIterator iter = model.listStatements();
			BasicTrippleStore basicTrippleStore = new BasicTrippleStore(); 
			
			ArrayList<String> nodes = new ArrayList<>(); 
			ArrayList<String> edges = new ArrayList<>(); 
			
			

			while(iter.hasNext()) { 
	            basicTrippleStore.Add(iter.next());
			}
			String protineURI = "http://purl.uniprot.org/uniprot/P0C9I5"; 
			ArrayList<String> predicates = new ArrayList<>(); 
			predicates.add(0, Globals.UNIPROT_BASE_IRI + "encodedBy");
			predicates.add(1, Globals.UNIPROT_BASE_IRI + "orfName"); 
			
			List<RDFNode> genes = basicTrippleStore.NestedSearch(protineURI, predicates); 
			
			for(int i = 0; i<genes.size(); i++) { 
				System.out.println(genes.get(i));
			}
			 predicates = new ArrayList<>(); 
			predicates.add(0, Globals.UNIPROT_BASE_IRI + "recommendedName");
			predicates.add(1, Globals.UNIPROT_BASE_IRI + "fullName"); 
 
			List<RDFNode> names = basicTrippleStore.NestedSearch(protineURI,predicates); 
			for(int i = 0; i<names.size(); i++) { 
				System.out.println(names.get(i));
			}
			
			Statement[] stms = basicTrippleStore.Search(protineURI); 
			String mainNode = "P0C9I5"; 
			String inode = "<node id=\"" + mainNode + "\"> " + 
							"<data key=\"DisplayText\">" + protineURI + "</data>" + 
							"</node>"; 
			nodes.add(inode); 
			String edgeName; 
			for(int i = 0; i<stms.length; i++) {
				
	            Resource p = stms[i].getPredicate();
	            RDFNode o = stms[i].getObject();
	            
	            edgeName = p.getLocalName() + "_" + i; 
	            String node = "<node id=\"" + edgeName + "\"> " + 
						"<data key=\"d0\">" + p.toString() + "</data>" + 
						"</node>"; 
	            
	            String edge = "<edge id=\"e_" + mainNode + "_" + i + "\""
	            		+ "source=\"" + mainNode + "\" target=\"" + edgeName + "\""
	            		+ "> " + 
						"<data key=\"d3\">" + p.toString() + "</data>" + 
						"</edge>"; 
	            
	            nodes.add(node); 
	            edges.add(edge); 
	            
	            System.out.println(p.toString() + "\t" + o.toString());
			}
			
			
			String graphML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"; 
			
			graphML += "<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" \r\n" + 
						"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \r\n" + 
						"xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns \r\n" + 
						"http://graphml.graphdrawing.org/xmlns/1.1/graphml.xsd\"> \r\n" + 
						"<!--Content: List of graphs and data--> \r\n";  
						
			
			graphML += "<key id=\"d0\" for=\"node\" attr.name=\"DisplayText\" attr.type=\"string\" />\r\n"; 	
			graphML += "<key id=\"d1\" for=\"node\" attr.name=\"NodeType\" attr.type=\"string\" />\r\n"; 
			graphML += "<key id=\"d2\" for=\"node\" attr.name=\"DatabaseName\" attr.type=\"string\" />\r\n"; 
			graphML += "<key id=\"d3\" for=\"edge\" attr.name=\"DisplayURI\" attr.type=\"string\" />\r\n"; 
			
			graphML += "<graph id=\"G\" edgedefault=\"undirected\">\r\n"; 
			
			for(int i = 0; i<nodes.size(); i++) { 
				graphML += nodes.get(i) + "\r\n"; 
			}
			for(int i = 0; i<edges.size(); i++) { 
				graphML += edges.get(i) + "\r\n"; 
			}
			
			
			graphML += "<graph>\r\n</graphml>"; 
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println(graphML);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		*/
		
	}
	
	public static void testNULL(Node n ) { 
		n = null; 
	}

}
