package cosmosChecker.spec.prov;

public interface IManager {
	
	/**
	 * it returns a list of provided interfaces 
	 * @return a list of provided interfaces
	 */
	String[] getProvidedInterfaces();
	
	/**
	 * 
	 * @param typeName
	 * @param facade
	 */
	void setProvidedInterface(String typeName, Object facade);
	
	void setProvidedInterfaces(String[] interfaces);
	
	String[] getRequiredInterfaces();
	
	Object getProvidedInterface(String name);
	
	void setRequiredInterface(String name,Object facade);
	
	void setRequiredInterfaces(String[] interfaces);
	
	Object getRequiredInterface(String name);
}
