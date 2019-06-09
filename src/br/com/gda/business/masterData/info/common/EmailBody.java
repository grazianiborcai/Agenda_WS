package br.com.gda.business.masterData.info.common;

public enum EmailBody {
	WELCOME("WELCOME");
	
	private final String codBody;
	
	
	private EmailBody (String cod) {
		codBody = cod;
	}
	
	
	
	public String getCodBody() {
		return codBody;
	}
}
