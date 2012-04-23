package cosmosChecker.spec.req;

public interface IDroolsMgt {

	/**
	 * this method fire the rules that has already been defined. It returns a object according
	 * to the RulesManager. It save the results obtained from each rule 
	 * @return the  
	 */
	public Object fireRules();
	
	
	/**
	 * this method defines which set of rules will be fired. The set of rules should be specified
	 * in the rules file. 
	 * @param rulesFile a file where the set of rules are specified
	 * @return return true if the file exists. Otherwise returns false
	 */
	public boolean setupRules(String rulesFile);
	
	/**
	 * to assert facts to the rules this method should be used. 
	 * @param fact an object that will be matched against the conditions of each rule
	 * @return return true if the object was correctly asserted. Otherwise returns false.
	 */
	public boolean assertFact(Object fact);
	
}
