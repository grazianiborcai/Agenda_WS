package br.com.mind5.file.fileImage.info;

import java.util.UUID;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class FimgSetterFilename implements InfoSetter<FimgInfo> {
	
	public FimgInfo setAttr(FimgInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.fileImgName = UUID.randomUUID().toString().replace("-", "");
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
