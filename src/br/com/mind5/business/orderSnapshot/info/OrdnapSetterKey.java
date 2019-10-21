package br.com.mind5.business.orderSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrdnapSetterKey implements InfoSetter<OrdnapInfo> {
	
	public OrdnapInfo setAttr(OrdnapInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(OrdnapInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OrdnapInfo setKey(OrdnapInfo recordInfo) {
		OrdnapInfo enforcedInfo = new OrdnapInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codOrder = recordInfo.codOrder;
		enforcedInfo.codSnapshot = recordInfo.codSnapshot;
		enforcedInfo.codLanguage = recordInfo.codLanguage;	
		enforcedInfo.username = recordInfo.username;	
		return enforcedInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
