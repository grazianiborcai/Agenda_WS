package br.com.gda.business.storeSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class StoreSetterCompKey implements InfoSetter<StorapInfo> {
	
	public StorapInfo setAttr(StorapInfo recordInfo) {
		checkArgument(recordInfo);
		return setCompKey(recordInfo);
	}
	
	
	
	private void checkArgument(StorapInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recordInfo.personData == null) {
			logException(new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo.personData" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StorapInfo setCompKey(StorapInfo recordInfo) {
		recordInfo.companyData.codOwner = recordInfo.codOwner;
		recordInfo.companyData.codCompany = recordInfo.codCompany;
		recordInfo.companyData.codEntityCateg = recordInfo.codEntityCateg;
		recordInfo.companyData.username = recordInfo.username;
		recordInfo.companyData.codLanguage = recordInfo.codLanguage;
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
