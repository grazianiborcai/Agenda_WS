package br.com.gda.business.scheduleMoviment.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.ScheduleStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class SchedovmSetterCounter implements InfoSetter<SchedovmInfo> {
	
	public SchedovmInfo setAttr(SchedovmInfo recordInfo) {
		checkArgument(recordInfo);
		return setCounter(recordInfo);
	}
	
	
	
	private void checkArgument(SchedovmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedovmInfo setCounter(SchedovmInfo recordInfo) {
		ScheduleStatus status = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		recordInfo = setWaiting(status, recordInfo);
		recordInfo = setConfirmed(status, recordInfo);
		recordInfo = setCount(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setWaiting(ScheduleStatus status, SchedovmInfo recordInfo) {
		if (ScheduleStatus.WAITING == status) 
			recordInfo.waiting = 1;
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setConfirmed(ScheduleStatus status, SchedovmInfo recordInfo) {
		if (ScheduleStatus.CONFIRMED == status) 
			recordInfo.confirmed = 1;
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setCount(SchedovmInfo recordInfo) {
		recordInfo.counter = 0;
		
		if (recordInfo.codScheduleStatusOld == null) 
			recordInfo.counter = 1;
		
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
