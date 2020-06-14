package br.com.mind5.masterData.common;

public enum Prostus {
	CREATED("CREATED"),
	CONTACTED("CONTACTED"),
	FINISHED("FINISHED");
	
	private final String codProspectStatus;
	
	
	private Prostus(String cod) {
		codProspectStatus = cod;
	}
	
	
	
	public String getCodProspectStatus() {
		return codProspectStatus;
	}
}
