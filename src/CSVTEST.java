import java.util.HashMap;
import java.util.Map;

import kr.seoul.amc.lggm.gccm.core.GeneSearchFactory;

public class CSVTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GeneSearchFactory gsf = new GeneSearchFactory(null); 

		
		Map<String, String[]> options = new HashMap<>(); 
		options.put("graphOption", new String[]{"csv"}); 
		System.out.println(gsf.GetGeneGraphML("gene", "CTNNB1;FGF19", "reactome;atlas;", "summerized", options));
	}

}
