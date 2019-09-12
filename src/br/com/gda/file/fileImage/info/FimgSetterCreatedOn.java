package br.com.gda.file.fileImage.info;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class FimgSetterCreatedOn implements InfoSetter<FimgInfo> {
	
	public FimgInfo setAttr(FimgInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdOn = genCreatedOn();
		return recordInfo;
	}
	
	
	
	private void checkArgument(FimgInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private LocalDateTime genCreatedOn() {
		return DefaultValue.localDateTimeNow();
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
