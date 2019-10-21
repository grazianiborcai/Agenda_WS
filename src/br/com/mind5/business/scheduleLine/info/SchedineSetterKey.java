package br.com.mind5.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedineSetterKey implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedineInfo setKey(SchedineInfo recordInfo) {
		SchedineInfo enforcedInfo = new SchedineInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codSchedule = recordInfo.codSchedule;
		enforcedInfo.codLanguage = recordInfo.codLanguage;
		enforcedInfo.username = recordInfo.username;
		
		return enforcedInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
