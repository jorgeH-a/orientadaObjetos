package edu.udelp.foros2;

import java.util.HashMap;
import java.util.Map;

public class UsuarioSingleton {
	private static UsuarioSingleton instance =null;
	private final Map<String,String> map = new HashMap<String,String>();
	private UsuarioSingleton() {
	}
	
	public static UsuarioSingleton getInstance(){
		if(null==instance) {
			instance = new UsuarioSingleton();
		}
		return instance;
	}
	
	public void add(String key,String value) {
		this.map.put(key, value);
	}
	
	public String getValue(String key) {
		return map.get(key);
	}
	
}