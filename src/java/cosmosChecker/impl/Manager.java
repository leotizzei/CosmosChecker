package cosmosChecker.impl;

import java.util.HashMap;


import cosmosChecker.spec.prov.ICosmosConstraints;
import cosmosChecker.spec.prov.IManager;

class Manager implements IManager {

	private HashMap providedInterfaces;
	private HashMap requiredInterfaces;
	private String[] listReqInt;
	private String[] listProvInt;
	
	Manager(){
		this.providedInterfaces = new HashMap();
		this.requiredInterfaces = new HashMap();
		
		//set provided interfaces
		ICosmosConstraints icc = new Facade_CosmosConstraints();
		this.setProvidedInterface("ICosmosConstraints",icc);
		
		//set list of provided interfaces
		String[] listProv = new String[1];
		listProv[0] = "ICosmosConstraints";
		this.setProvidedInterfaces(listProv);
		
		//set list of required interfaces
		this.setRequiredInterfaces(null);
		
	}
	
	
	/**
	 * return list of provided interfaces
	 */
	public String[] getProvidedInterfaces() {

		return this.listProvInt;
	}

	
	public void setProvidedInterface(String typeName, Object facade) {
		this.providedInterfaces.put(typeName,facade);

	}

	public void setProvidedInterfaces(String[] interfaces) {
		this.listProvInt = interfaces;

	}

	public String[] getRequiredInterfaces() {
		return this.listReqInt;
	}

	public Object getProvidedInterface(String name) {
		
		return this.providedInterfaces.get(name);
	}

	public void setRequiredInterface(String name, Object facade) {
		this.requiredInterfaces.put(name,facade);

	}

	public void setRequiredInterfaces(String[] interfaces) {
		this.listReqInt = interfaces;

	}

	public Object getRequiredInterface(String name) {
		
		return this.requiredInterfaces.get(name);
	}

	
	
}
