package br.com.mind5.business.masterData.info.common;

public enum EmailBody {
	PROSPECT_STORE("PROSPECT_STORE"),
	WELCOME("WELCOME");
	
	private final String codBody;
	
	
	private EmailBody (String cod) {
		codBody = cod;
	}
	
	
	
	public String getCodBody() {
		return codBody;
	}
}
