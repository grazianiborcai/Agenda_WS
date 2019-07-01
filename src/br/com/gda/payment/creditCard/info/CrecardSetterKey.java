package br.com.gda.payment.creditCard.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class CrecardSetterKey implements InfoSetter<CrecardInfo> {
	
	public CrecardInfo setAttr(CrecardInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(CrecardInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CrecardInfo setKey(CrecardInfo recordInfo) {
		CrecardInfo enforcedRecord = new CrecardInfo();
		enforcedRecord.codOwner = recordInfo.codOwner;
		enforcedRecord.codPayCustomer = recordInfo.codPayCustomer;
		enforcedRecord.codCreditCard = recordInfo.codCreditCard;
		enforcedRecord.codLanguage = recordInfo.codLanguage;
		
		return enforcedRecord;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
