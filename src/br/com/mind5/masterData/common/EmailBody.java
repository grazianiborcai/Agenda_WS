package br.com.mind5.masterData.common;

public enum EmailBody {
	OTP_USER_PASSWORD("OTP_USER_PASSWORD"),
	PROSPECT_STORE("PROSPECT_STORE"),	
	SCHEDULE_CONFIRMATION("SCHEDULE_CONFIRMATION"),
	USER_PASSWORD_CHANGE("USER_PASSWORD_CHANGE"),
	WELCOME("WELCOME");
	
	private final String codBody;
	
	
	private EmailBody (String cod) {
		codBody = cod;
	}
	
	
	
	public String getCodBody() {
		return codBody;
	}
}
