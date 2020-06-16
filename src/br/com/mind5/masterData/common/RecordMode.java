package br.com.mind5.masterData.common;

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
