package br.com.gda.file.fileUpload.info;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class FilupSetterFilename implements InfoSetter<FilupInfo> {
	
	public FilupInfo setAttr(FilupInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.fileImgName = UUID.randomUUID().toString().replace("-", "");
		return recordInfo;
	}
	
	
	
	private void checkArgument(FilupInfo recordInfo) {
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
