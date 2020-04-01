package br.com.mind5.file.fileImageSearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class FimarchSetterMat implements InfoSetter<FimarchInfo> {
	
	public FimarchInfo setAttr(FimarchInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(FimarchInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private FimarchInfo setCodEntityCateg(FimarchInfo recordInfo) {
		FimarchInfo result = new FimarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codMat = recordInfo.codMat; 
		result.codLanguage = recordInfo.codLanguage; 
		result.username = recordInfo.username; 
		
		return result;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
