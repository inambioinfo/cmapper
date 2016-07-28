<% 
//boolean navbarmode = false; 
//navbarmode = request.getParameter("mode").equals("navbar") ; 
%>

<div id="filters">
					<select id="taxonomicOrganisims" class="filtering-options1" 
						data-selected-text-format="count"
						multiple="multiple" name="taxonomicOrganisims">
						<option value="" selected="selected">All Organisims</option>
					</select>
					<select id="atlasOrgans" class="filtering-options1" 
						multiple="multiple" name="atlasOrgans"
						data-selected-text-format="count">
						<option value="" selected="selected">All Organs</option>
					</select>
					<select id="pathWayOption" class="filtering-options" name="pathWayOption">
						<option value="allPathways" selected="selected">All Pathways</option>
						<option value="metabolicPathways">Metabolic Pathways</option>
						<option value="signalingPathways">Signaling Pathways</option>
					</select>
					<select id="graphOptions" class="filtering-options" name="graphOptions">
						<option value="detailed" selected="selected">All Connections</option>
						<option value="summerized">Shared Connections</option>
					</select>
					<select id="outputOption" class="filtering-options" name="outputOption">
						<option value="ViewGraph" selected="selected">View Graph </option>
						<option value="DownloadGraphML">Download GraphML</option>
						<option value="DownloadJSON">Download JSON</option>
						<option value="DownloadCSV">Download CSV</option>
					</select>
				</div>
				
                <div class="intro-lead-in">Please Enter Gene or Small Molecule Names</div>
                <div id="main-input">
                <div id="databaseFilter-container" class="input-lg" >
                
                
               	<span id="geneOrSmallMolecule"  >
               	
				<input type="radio" name="gene_molecule_op" value="gene"
					checked="checked" id="geneRadioButton" /><label
					for="geneRadioButton">Gene</label> <input type="radio"
					name="gene_molecule_op" value="molecule"
					id="meleculeRadioButton" /> <label for="meleculeRadioButton">Small
					Molecule</label>
				
				</span>
				<span>
				<select class="selectpicker" id="databaseFilters" multiple 
					title="<span class='fa fa-database'></span> Databases" 
					data-selected-text-format="static" >
					  <option style="background: #C6EFF7"  selected="selected" value="associatedGenes">Associated Genes</option>
					  <option style="background: #D63194" selected="selected" value="organism">Uniprot</option>
					  <option style="background: #FF0000" selected="selected" value="atlas">Up Expressions</option>
					  <option style="background: #7BC618" selected="selected" value="atlas">Down Expressions</option>
					  <option style="background: #BFBFBF" selected="selected" value="atlas">Up-Down Expressions</option>
					  <option style="background: #FF9C4A" selected="selected" value="reactome">Reactome Pathways<</option>
					  <option style="background: #FFFF6B" selected="selected" value="chembl">Small Molecules</option>
					  <option style="background: #847308" selected="selected" value="biomodels">Bio Models</option>
					  <option style="background: #082984; color: #FFF"selected="selected" value="biosamples">Bio Samples</option>
					</select>
				</span>
						
				</div>
                
				<div id="gene-input-container" class="header-form"><div class="tokenfield-container" id="tokenfield-container">
				
				 <input type="text" class="form-control input-xl" id="genesList"  required data-validation-required-message="Please enter your name.">
                </div>
                </div>
                </div>
				<span id="geneSubmitButton-container"> 
				<a id="geneSubmitButton" class="btn btn-xl">Explore Connections</a>
				</span>