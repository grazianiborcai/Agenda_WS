package br.com.mind5.file.fileImage.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class FimgSetterOwner implements InfoSetter<FimgInfo> {
	
	public FimgInfo setAttr(FimgInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codOwnerRef = recordInfo.codOwner;
		recordInfo.codPerson = DefaultValue.number();
		recordInfo.codEmployee = DefaultValue.number();
		recordInfo.codMat = DefaultValue.number();
		recordInfo.codStore = DefaultValue.number();
		recordInfo.codCustomer = DefaultValue.number();
		recordInfo.codUser = DefaultValue.number();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(FimgInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
