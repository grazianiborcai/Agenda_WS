package br.com.gda.file.fileImage.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class FimgSetterOwner implements InfoSetter<FimgInfo> {
	
	public FimgInfo setAttr(FimgInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codOwnerRef = recordInfo.codOwner;
		recordInfo.codPerson = DefaultValue.number();
		recordInfo.codMat = DefaultValue.number();
		recordInfo.codCompany = DefaultValue.number();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(FimgInfo recordInfo) {
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
