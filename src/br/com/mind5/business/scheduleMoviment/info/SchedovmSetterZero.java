package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedovmSetterZero implements InfoSetter<SchedovmInfo> {
	
	public SchedovmInfo setAttr(SchedovmInfo recordInfo) {
		checkArgument(recordInfo);
		return setZero(recordInfo);
	}
	
	
	
	private void checkArgument(SchedovmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedovmInfo setZero(SchedovmInfo recordInfo) {
		ScheduleStatus status = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatus); 		
		ScheduleStatus statusOld = null; 
		
		if (recordInfo.codScheduleStatus != null)
			statusOld = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatusOld); 
		
		recordInfo = setZero(status, statusOld, recordInfo);
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setZero(ScheduleStatus status, ScheduleStatus statusOld, SchedovmInfo recordInfo) {
		if (statusOld == null)
			return recordInfo;
		
		if (status == statusOld) {
			recordInfo.waiting = 0;
			recordInfo.confirmed = 0;
			recordInfo.counter = 0;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
