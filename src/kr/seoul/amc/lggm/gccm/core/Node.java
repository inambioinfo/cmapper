package kr.seoul.amc.lggm.gccm.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import com.sun.javafx.collections.MappingChange.Map;

public class Node {
	public String ID; 
	public HashMap<String, String> Data = new HashMap<String, String>(); 
	public HashSet<String> connections = new HashSet<>(); 
	public float degree = 0.0f; 
	
	public Node(String ID) { 
		this.ID = ID; 
		degree = 0.0f; 
	}
	
	public void IncreaseDegree() { 
		degree++; 
	}
	
	public void AddData(String key, String value) { 
		this.Data.put(key, value); 
	}
}
