package cosmosChecker.impl;

import java.io.File;

import droolsmgr.spec.prov.IDroolsMgt;
import droolsmgr.spec.prov.IManager;
import droolsmgr.impl.ComponentFactory;

class Controller {

	
	protected boolean manager(File componentFile, String setOfRulesPath, String componentPackage){
		if( ( componentFile != null ) && ( setOfRulesPath != null ) && ( componentFile.exists() ) ){
			
				IManager imanager = ComponentFactory.createInstance();
				IDroolsMgt droolsmgr = (IDroolsMgt) imanager.getProvidedInterface("IDroolsMgt");
				//droolsmgr.setupRules( setOfRulesPath );
				
				//asserting facts
				Object[] params = new Object[2];
				params[ 0 ] = componentFile;
				params[ 1 ] = componentPackage;
				/*boolean assertCompPath = droolsmgr.assertFact( componentFile );
				boolean assertCompPack = droolsmgr.assertFact( componentPackage );
				if( assertCompPath && assertCompPack){*/
				
				
				
				Boolean result = (Boolean) droolsmgr.fireRules( setOfRulesPath, params);
				if( result != null )
					return result.booleanValue();
				else{
					System.err.println("Result is null");
					return false;
				}

				/*}
				else{
					System.err.println("It couldn't assert the facts");
					return false;
				}
				*/
			
		}
		else{
			System.err.println("Controller::manager()\n - Either the parameter is null or the file does not exist");
			return false;
		}
	}
	
}
