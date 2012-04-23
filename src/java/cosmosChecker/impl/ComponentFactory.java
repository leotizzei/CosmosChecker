package cosmosChecker.impl;

import cosmosChecker.spec.prov.IManager;



public class ComponentFactory {
	public static IManager createInstance(){
		System.out.println("hello world!!");
		ClassLoader cl = ComponentFactory.class.getClassLoader();
		System.out.println(cl.getClass().getName());
		IManager im = new Manager();
		return im;
	}
	
	
	
}
