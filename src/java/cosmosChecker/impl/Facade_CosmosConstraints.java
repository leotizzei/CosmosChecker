package cosmosChecker.impl;

import java.io.File;

import cosmosChecker.spec.prov.ICosmosConstraints;

public class Facade_CosmosConstraints implements ICosmosConstraints {

	public static void main(String[] args){
		ICosmosConstraints cosmos = new Facade_CosmosConstraints();

		String cosmosRules = "/home/lsd/ra001973/workspace2/CosmosChecker/src/rules/cosmosRules.drl";
		//"/home/lsd/ra001973/workspace2/CosmosChecker/src/rules/cosmosRules.drl";

		String componentPath = "/home/lsd/ra001973/componentSample/patrick/ComponenteDeNegocio/gerenciamentoConta";
		//"/home/lsd/ra001973/workspace2/estudoDeCaso_newPetstore/newPetstore/com/sun/javaee/blueprints/petstore/captcha/";
		
		String componentPack = "br.unicamp.ic.estCaso.negocio.gerenciamentoConta";
		//"com.sun.javaee.blueprints.petstore.captcha";
		boolean result = cosmos.isCosmos(cosmosRules , componentPath , componentPack);
		
		
		System.out.println("Is it a COSMOS component? "+result);


	}
	
	/**
	 * @param componentPath this argument could be either a jar file or the component directory
	 * @param componentPackage the first package of the component
	 * @param cosmosRulesFile the complete path to the file of rules
	 */
	public boolean isCosmos(String cosmosRulesFile, String componentPath, String componentPackage ) {
		if( ( cosmosRulesFile != null ) && ( componentPath != null  ) ){
			// check the parameters
			boolean result = false;
			
			// check if parameters exists
			result = this.checkValues(cosmosRulesFile, componentPath);
			if( result == false )
				return result;
			
			File componentFile = new File( componentPath );
			Controller control = new Controller();
			result = control.manager( componentFile , cosmosRulesFile, componentPackage);
			return result;
		}
		else{
			System.err.println("Either rules file or component path is null");
			return false;
		}


	}

	/**
	 * this method just check if both parameters exists. Otherwise, return false.
	 * @param cosmosRulesFile the complete path to the file of rules
	 * @param componentPath this argument could be either a jar file or the component directory
	 * @return
	 */
	private boolean checkValues(String cosmosRulesFile, String componentPath ){
		File rules = new File( cosmosRulesFile );
		if( !rules.exists() || !rules.isFile() )
			return false;
		
		File component = new File( componentPath );
		if( !component.exists() )
			return false;
			
		return true;
		
	}
	
	
	
}
