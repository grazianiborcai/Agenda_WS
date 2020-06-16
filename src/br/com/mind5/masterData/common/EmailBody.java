package br.com.mind5.masterData.common;

public enum EmailBody {
	PROSPECT_STORE("PROSPECT_STORE"),
	OTP_USER_PASSWORD("OTP_USER_PASSWORD"),
	WELCOME("WELCOME");
	
	private final String codBody;
	
	
	private EmailBody (String cod) {
		codBody = cod;
	}
	
	
	
	public String getCodBody() {
		return codBody;
	}
}
