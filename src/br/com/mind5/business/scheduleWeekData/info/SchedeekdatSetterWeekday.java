package br.com.mind5.business.scheduleWeekData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedeekdatSetterWeekday implements InfoSetter<SchedeekdatInfo> {
	
	public SchedeekdatInfo setAttr(SchedeekdatInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodWeekday(recordInfo);
	}
	
	
	
	private void checkArgument(SchedeekdatInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedeekdatInfo setCodWeekday(SchedeekdatInfo recordInfo) {
		SchedeekdatInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.codWeekday = enforcedInfo.date.getDayOfWeek().getValue();		
		return enforcedInfo;
	}
	
	
	
	private SchedeekdatInfo makeClone(SchedeekdatInfo recordInfo) {
		try {
			return (SchedeekdatInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
