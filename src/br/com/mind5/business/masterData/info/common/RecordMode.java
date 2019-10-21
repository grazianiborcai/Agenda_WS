package br.com.mind5.business.masterData.info.common;

public enum RecordMode {
	DELETED("X"), OK(" ");
	
	private final String recordMode;
	
	
	private RecordMode(String codRecordMode) {
		recordMode = codRecordMode;
	}
	
	
	
	public String getCodRecordMode() {
		return recordMode;
	}
}
