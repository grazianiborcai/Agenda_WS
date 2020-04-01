package br.com.mind5.business.owner.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OwnerSetterCompKey implements InfoSetter<OwnerInfo> {
	
	public OwnerInfo setAttr(OwnerInfo recordInfo) {
		checkArgument(recordInfo);
		return setCompKey(recordInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.personData == null) {
			logException(new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OwnerInfo setCompKey(OwnerInfo recordInfo) {
		recordInfo.companyData.codOwner = recordInfo.codOwner;
		recordInfo.companyData.codCompany = recordInfo.codCompany;
		recordInfo.companyData.username = recordInfo.username;
		recordInfo.companyData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
