package br.com.gda.business.masterData.info.common;

public enum Langu {
	ENGLISH("EN");
	
	
	private final String codLanguage;
	
	
	private Langu(String cod) {
		codLanguage = cod;
	}
	
	
	
	public String getCod() {
		return codLanguage;
	}
}
