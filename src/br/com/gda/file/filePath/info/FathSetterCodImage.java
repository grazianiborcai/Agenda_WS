package br.com.gda.file.filePath.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.FilePath;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
