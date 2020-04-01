package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		
		SystemLog.logError(this.getClass(), e);
	}	
}
