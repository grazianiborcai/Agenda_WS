package br.com.gda.payment.tokenMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class AccemoipSetterObfuscate implements InfoSetter<TokemoipInfo> {
	
	public TokemoipInfo setAttr(TokemoipInfo recordInfo) {
		checkArgument(recordInfo);
		return setSetup(recordInfo);
	}
	
	
	
	private void checkArgument(TokemoipInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private TokemoipInfo setSetup(TokemoipInfo recordInfo) {
		TokemoipInfo obfuscated = new TokemoipInfo();
		
		obfuscated.codOwner = recordInfo.codOwner;
		obfuscated.codStore = recordInfo.codStore;	
		obfuscated.codPayPartner = recordInfo.codPayPartner;
		obfuscated.url = recordInfo.url;
		obfuscated.codLanguage = recordInfo.codLanguage;
		obfuscated.username = recordInfo.username;
		
		return obfuscated;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
