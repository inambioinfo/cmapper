package kr.seoul.amc.lggm.gccm.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class GraphMLWriter extends Object {
	public HashMap<String, Node> nodes = new HashMap<>(); 
	public HashMap<String, Edge> edges = new HashMap<>(); 
	public List<Key> keys = new ArrayList<>(); 
	public float EdgeThreshhold = 1.0f;  

	public GraphMLWriter() { }
	public GraphMLWriter(float threshold) { 
		EdgeThreshhold = threshold; 
	}



	public boolean AddNode(Node node) { 
		if(nodes.containsKey(node.ID) == false) { 
			this.nodes.put(node.ID, node); 
			return true; 
		} return false; 

	}
	public boolean AddEdge(Edge edge) { 
		//System.out.println(edge.ID + "\t"  +edge.weight); 
		if(this.nodes.containsKey(edge.to) && this.nodes.containsKey(edge.from)) { 
			if(edge.weight >= EdgeThreshhold) { 
				if(edges.containsKey(edge.ID) == false) { 
					this.edges.put(edge.ID, edge); 
					this.nodes.get(edge.to).degree += edge.weight; 
					this.nodes.get(edge.from).degree += edge.weight; 
					//this.nodes.get(edge.from).IncreaseDegree(); 
					return true; 
				}
			} }  return false; 

	}

	public boolean ContainNode(String nodeID) { 
		return nodes.containsKey(nodeID); 
	} 

	public boolean ContainEdge(String edgeID) { 
		return edges.containsKey(edgeID); 
	}

	public void AddKey(Key key) { 
		this.keys.add(key); 
	}

	public void AddConnection(String NodeID, String connection) { 
		this.nodes.get(NodeID).connections.add(connection); 
	}
	public String GetGraphML() { 
		String graphML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"; 

		graphML += "<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" \r\n" + 
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \r\n" + 
				"xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns \r\n" + 
				"http://graphml.graphdrawing.org/xmlns/1.1/graphml.xsd\"> \r\n" + 
				"<!--Content: List of graphs and data--> \r\n";  
		graphML += "<graph id=\"G\" edgedefault=\"directed\">\r\n"; 


		int size = keys.size(); 
		Key key = null; 

		for(int i = 0; i<size; i++) { 

			key = keys.get(i); 
			graphML += "<key id=\""+key.ID+"\" "
					+ "for=\""+key.For+"\" "
					+ "attr.name=\""+key.Name+"\" "
					+ "attr.type=\""+key.Type+"\" />\r\n"; 
		}

		size = nodes.size(); 
		Node node = null; 
		Iterator it = nodes.entrySet().iterator(); 
		Map.Entry pair = null; 
		while(it.hasNext()) { 
			pair =  (Map.Entry)it.next();
			node = (Node) pair.getValue(); 
			/*
			if(node.connections.size() == 0) { 
				continue; 
			}
			 */
			//System.out.println(node.ID + "\t" + node.degree); 
			if(node.degree < 1) { continue; } 



			String nodeString = "<node id=\"" + node.ID + "\"> "; 
			@SuppressWarnings("rawtypes")
			Iterator subit = node.Data.entrySet().iterator();
			while(subit.hasNext()) { 
				@SuppressWarnings("rawtypes")
				Map.Entry subpair = (Map.Entry)subit.next();
				nodeString += "<data key=\""+subpair.getKey()+"\">" + subpair.getValue() + "</data>"; 
			}
			nodeString += "</node>\r\n"; 
			graphML += nodeString; 
		}



		size = edges.size(); 
		it = edges.entrySet().iterator(); 
		Edge edge = null; 
		pair = null; 
		while(it.hasNext()) { 
			pair =  (Map.Entry)it.next();
			edge = (Edge) pair.getValue();
			if(nodes.get(edge.to).degree < 1.0f || nodes.get(edge.from).degree < 1.0f)
				continue; 
			String nodeString = "<edge id=\"" + edge.ID + "\" "
					+ "source=\""+edge.from+"\"  target=\""+edge.to+"\"> "; 
			Iterator subit = edge.Data.entrySet().iterator();
			while(subit.hasNext()) { 
				Map.Entry subpair = (Map.Entry)subit.next();
				nodeString += "<data key=\""+subpair.getKey()+"\">" + subpair.getValue() + "</data>"; 
			}
			nodeString += "</edge>\r\n"; 
			graphML += nodeString; 
		}

		graphML += "</graph>\r\n</graphml>"; 

		return graphML; 
	}
	
	public String GetCSVString() { 
		String csvString = "";
		int size = keys.size(); 
		Key key = null; 
		ArrayList<String> nodeKeysSeq = new ArrayList<>(); 
		for(int i = 0; i<size; i++) { 

			key = keys.get(i); 
			if(key.For.equals("node") || key.For.equals("all")) {
				csvString = csvString + key.Name + "\t"; 
				nodeKeysSeq.add(key.ID); 
			}
			
		}
		
		csvString = csvString + "Parent Node \r\n"; 
		
		Iterator it = null; 
		Map.Entry pair = null; 
		
		Map<String, ArrayList<String>> connectivyInfo = new HashMap<String, ArrayList<String>>(); 
		
		size = edges.size(); 
		it = edges.entrySet().iterator(); 
		Edge edge = null; 
		pair = null; 
		while(it.hasNext()) { 
			pair =  (Map.Entry)it.next();
			edge = (Edge) pair.getValue();
			if(nodes.get(edge.to).degree < 1.0f || nodes.get(edge.from).degree < 1.0f)
				continue; 
			if(connectivyInfo.containsKey(edge.to) == false) {
				connectivyInfo.put(edge.to, new ArrayList<String>()); 
			} 
			connectivyInfo.get(edge.to).add(edge.from); 
			

		}

		
		size = nodes.size(); 
		Node node = null; 
		it = nodes.entrySet().iterator(); 
		pair = null; 
		//String connectors; 
		
		while(it.hasNext()) { 
			pair =  (Map.Entry)it.next();
			node = (Node) pair.getValue(); 

			if(node.degree < 1) { continue; } 
			
			csvString = csvString + node.ID + ",";
			size = nodeKeysSeq.size(); 
			for(int i = 0; i<size; i++) {
				csvString = csvString + node.Data.get(nodeKeysSeq.get(i)) + "\t"; 
			}
			
			csvString = csvString + connectivyInfo.get(node.ID) + "\r\n"; 
			System.out.println(csvString);
		}
		
		return csvString; 
	}
	
	public JSONObject GetJSONString() { 
		JSONObject mainObject = new JSONObject(); 
		
		JSONArray jsonnodes = new JSONArray(); 
		JSONArray jsonedges = new JSONArray(); 
		
		Node node = null; 
		Iterator it = nodes.entrySet().iterator(); 
		Map.Entry pair = null; 
		while(it.hasNext()) { 
			pair =  (Map.Entry)it.next();
			node = (Node) pair.getValue(); 
			
			JSONObject jsonnode = new JSONObject(); 
			//jsonnode.
			jsonnode.put("id", node.ID); 
			jsonnode.put("label", node.Data.get("l0")); 
			jsonnode.put("group", node.Data.get("dbName")); 
			jsonnodes.put(jsonnode); 
		}
		
		it = edges.entrySet().iterator(); 
		Edge edge = null; 
		pair = null; 
		while(it.hasNext()) { 
			pair =  (Map.Entry)it.next();
			edge = (Edge) pair.getValue();
			
			JSONObject jsonedge = new JSONObject(); 
			jsonedge.put("id", edge.ID); 
			jsonedge.put("target", edge.to); 
			jsonedge.put("source", edge.from); 
			jsonedges.put(jsonedge); 
		}
		
		
		mainObject.put("nodes", jsonnodes); 
		mainObject.put("edges", jsonedges); 
		
		return mainObject; 
	}
}
