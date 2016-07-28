import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.scripts.JS;
import kr.seoul.amc.lggm.gccm.core.GeneSearchFactory;
import sun.nio.cs.ext.MacArabic;

public class JSONTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GeneSearchFactory gsf = new GeneSearchFactory(null); 
		
		Map<String, String[]> options = new HashMap<>(); 
		options.put("graphOption", new String[]{"json"}); 
		System.out.println(gsf.GetGeneGraphML("gene", "CTNNB1;FGF19", "reactome;atlas;", "summerized", options));
		

	}

}
