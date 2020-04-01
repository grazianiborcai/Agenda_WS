package br.com.mind5.file.filePath.info;

import br.com.mind5.business.masterData.info.common.FilePath;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class FathSetterCodImage implements InfoSetter<FathInfo> {
	
	public FathInfo setAttr(FathInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codFilePath = FilePath.FILE_IMAGE.getCodPath();
		return recordInfo;
	}
	
	
	
	private void checkArgument(FathInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
