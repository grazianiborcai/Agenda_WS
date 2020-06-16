package br.com.mind5.masterData.authorizationGroup.info;

public enum Authgroup {
	OWNER("OWNER"), 
	STORE_MANAGER("STORE_MANAGER"), 
	EMPLOYEE("EMPLOYEE"), 
	CUSTOMER("CUSTOMER"),
	DAEMON("DAEMON");
	
	private final String codAuthGroup;
	
	
	private Authgroup(String authGroup) {
		codAuthGroup = authGroup;
	}
	
	
	
	public String getCodAuthGroup() {
		return codAuthGroup;
	}
}
