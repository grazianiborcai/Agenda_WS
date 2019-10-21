package br.com.mind5.business.scheduleMonthData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedonthatSetterWeekday implements InfoSetter<SchedonthatInfo> {
	
	public SchedonthatInfo setAttr(SchedonthatInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodWeekday(recordInfo);
	}
	
	
	
	private void checkArgument(SchedonthatInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedonthatInfo setCodWeekday(SchedonthatInfo recordInfo) {
		SchedonthatInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.codWeekday = enforcedInfo.date.getDayOfWeek().getValue();		
		return enforcedInfo;
	}
	
	
	
	private SchedonthatInfo makeClone(SchedonthatInfo recordInfo) {
		try {
			return (SchedonthatInfo) recordInfo.clone();
			
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
