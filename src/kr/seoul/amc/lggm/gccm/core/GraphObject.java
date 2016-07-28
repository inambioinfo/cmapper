package kr.seoul.amc.lggm.gccm.core;

import java.util.ArrayList;

public class GraphObject {
	public String ObjectID; 
	public String ObjectLabel; 
	public String ObjectURL; 
	public ArrayList<String> AtlasDirection; 
	public ArrayList<String> Proteins; 
	public ArrayList<String> Genes;  
	
	public GraphObject(String ID, String Label, String Protein, String Gene, String url) { 
		this.ObjectID = ID; 
		this.ObjectLabel = Label; 
		this.ObjectURL = url; 
		this.Proteins = new ArrayList<>(); 
		this.Genes = new ArrayList<>(); 
		this.AtlasDirection = new ArrayList<>(); 
		this.Proteins.add(Protein); 
		this.Genes.add(Gene); 
	}
	
	public void AddProtein(String Protein) { 
		if(this.Proteins.contains(Protein) == false) 
			this.Proteins.add(Protein); 
	} 
	public void AddGene(String Gene) { 
		if(this.Genes.contains(Gene) == false) { 
			this.Genes.add(Gene); 
		}
	}
	public void AddAtlasDirection(String dir) { 
		String[] dirs = dir.split(","); 
		for( int i = 0; i<dirs.length; i++) { 
		if(AtlasDirection.contains(dirs[i]) == false) {
			AtlasDirection.add(dirs[i]); 
		}
		}
	}
	public String GetAtlasDirections() {
		if(AtlasDirection.size() == 1) {
			return AtlasDirection.get(0); 
		} else if(AtlasDirection.size() == 2) {
			return AtlasDirection.get(0) + "_" + AtlasDirection.get(1); 
		}
		else {
			return ""; 
		}
	}
	
	
	public boolean HasMultiGeneRelations() { 
		if(this.Genes.size() > 1) { 
			return true; 
		} else { return false;  } 
		
	}
	
	public boolean HasDefinedGenesRelations(int i) { 
		if(this.Genes.size() >= i) { 
			return true; 
		} else { return false;  } 
	}
	
	//public boolean
}
