package br.com.gda.business.schedule.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderemSetterKey implements InfoSetter<ScheduInfo> {
	
	public ScheduInfo setAttr(ScheduInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(ScheduInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private ScheduInfo setKey(ScheduInfo recordInfo) {
		ScheduInfo enforcedInfo = new ScheduInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codOrder = recordInfo.codOrder;
		enforcedInfo.codLanguage = recordInfo.codLanguage;	
		return enforcedInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
