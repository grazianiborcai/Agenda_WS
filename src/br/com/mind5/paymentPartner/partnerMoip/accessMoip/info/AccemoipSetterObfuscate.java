package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class AccemoipSetterObfuscate implements InfoSetter<AccemoipInfo> {
	
	public AccemoipInfo setAttr(AccemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(AccemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private AccemoipInfo setSetup(AccemoipInfo recordInfo) {
		AccemoipInfo obfuscated = new AccemoipInfo();
		
		obfuscated.codOwner = recordInfo.codOwner;
		obfuscated.codStore = recordInfo.codStore;	
		obfuscated.codPayPartner = recordInfo.codPayPartner;
		obfuscated.url = recordInfo.url;
		obfuscated.codLanguage = recordInfo.codLanguage;
		obfuscated.username = recordInfo.username;
		
		return obfuscated;
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
