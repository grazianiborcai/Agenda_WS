package br.com.mind5.servlet.filter.common;

public enum Platform {
	MOBILE("mobile"),
	WEB("web");
	
	private String codPlatform;
	
	
	private Platform (String cod) {
		codPlatform = cod;
	}


	
	public String getCodPlatform() {
		return codPlatform;
	}
}
