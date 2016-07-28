package kr.ac.ulsan.ccgd.gccm.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import kr.seoul.amc.lggm.gccm.core.GeneSearchFactory;

@Path("gene")
public class Gene {
    public static final String CLICHED_MESSAGE = "Hello World!";

    @GET
    @Path("{geneName}")
    @Produces("text/plain")
    public String GentGene(@PathParam("geneName") String geneName ) {
    	GeneSearchFactory gsf = new GeneSearchFactory(null); 
    	Map<String, String[]> options = new HashMap<>(); 
		options.put("graphOption", new String[]{"json"}); 
    	return gsf.GetGeneGraphML("gene", geneName, "reactome;atlas;biomodels;biosamples;chembl", "detailed", options); 
        //return CLICHED_MESSAGE + a;
    }
    
    
    
    @GET
    @Path("/shoaib")
    @Produces("text/plain")
    public String getShoaib() {
        return "HI SHOAIB";
    }
}
