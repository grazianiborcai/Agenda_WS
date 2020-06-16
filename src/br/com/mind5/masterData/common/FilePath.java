package br.com.mind5.masterData.common;

public enum FilePath {
	FILE_IMAGE("IMG_PATH");
	
	
	private final String codFilePath;
	
	
	private FilePath(String codPath) {
		codFilePath = codPath;
	}

	

	public String getCodPath() {
		return codFilePath;
	}
}
