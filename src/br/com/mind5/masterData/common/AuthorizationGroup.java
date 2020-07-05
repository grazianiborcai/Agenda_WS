package br.com.mind5.masterData.common;

public enum AuthorizationGroup {
	ANONYMOUS("ANONYMOUS"),
	CUSTOMER("CUSTOMER"),
	DAEMON("DAEMON"),
	EMPLOYEE("EMPLOYEE"),
	OWNER("OWNER"), 
	STORE_MANAGER("STORE_MANAGER");
	
	private final String codAuthGroup;
	
	
	private AuthorizationGroup(String authGroup) {
		codAuthGroup = authGroup;
	}
	
	
	
	public String getCodAuthGroup() {
		return codAuthGroup;
	}
}
