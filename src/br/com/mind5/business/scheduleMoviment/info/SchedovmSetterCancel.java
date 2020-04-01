package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedovmSetterCancel implements InfoSetter<SchedovmInfo> {
	
	public SchedovmInfo setAttr(SchedovmInfo recordInfo) {
		checkArgument(recordInfo);
		return setCancel(recordInfo);
	}
	
	
	
	private void checkArgument(SchedovmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedovmInfo setCancel(SchedovmInfo recordInfo) {
		ScheduleStatus status = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		if (isCancelled(status) == false)
			return recordInfo;
		
		ScheduleStatus statusOld = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatusOld); 
		
		recordInfo = cancelWaiting(statusOld, recordInfo);
		recordInfo = cancelConfirmed(statusOld, recordInfo);
		
		return recordInfo;
	}
	
	
	
	private boolean isCancelled(ScheduleStatus status) {
		return ScheduleStatus.CANCELLED == status;
	}
	
	
	
	private SchedovmInfo cancelWaiting(ScheduleStatus status, SchedovmInfo recordInfo) {
		if (ScheduleStatus.WAITING == status) {
			recordInfo.waiting = -1;
			recordInfo.counter = -1;
		}
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo cancelConfirmed(ScheduleStatus status, SchedovmInfo recordInfo) {
		if (ScheduleStatus.CONFIRMED == status) {
			recordInfo.confirmed = -1;
			recordInfo.counter = -1;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
