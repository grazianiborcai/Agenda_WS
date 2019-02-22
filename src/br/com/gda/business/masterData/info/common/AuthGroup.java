package br.com.gda.business.masterData.info.common;

public enum AuthGroup {
	OWNER("OWNER"), STORE_MANAGER("STORE_MANAGER");
	
	private final String codAuthGroup;
	
	
	private AuthGroup(String authGroup) {
		codAuthGroup = authGroup;
	}
	
	
	
	public String getCodAuthGroup() {
		return codAuthGroup;
	}
}
