package br.com.gda.business.scheduleMoviment.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.ScheduleStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class SchedovmSetterReverse implements InfoSetter<SchedovmInfo> {
	
	public SchedovmInfo setAttr(SchedovmInfo recordInfo) {
		checkArgument(recordInfo);
		return setReverse(recordInfo);
	}
	
	
	
	private void checkArgument(SchedovmInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedovmInfo setReverse(SchedovmInfo recordInfo) {
		if (isStatusOldEmpty(recordInfo))
			return recordInfo;
		
		
		ScheduleStatus status = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		if (isCancelled(status))
			return recordInfo;
		
		
		ScheduleStatus statusOld = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatusOld); 		
		
		if (isUnchanged(status, statusOld)) 
			return recordInfo;
		
		
		
		recordInfo = reverseWaiting(statusOld, recordInfo);
		recordInfo = reverseConfirmed(statusOld, recordInfo);
		
		return recordInfo;
	}
	
	
	
	private boolean isCancelled(ScheduleStatus status) {
		return ScheduleStatus.CANCELLED == status;
	}
	
	
	
	private boolean isStatusOldEmpty(SchedovmInfo recordInfo) {		
		return recordInfo.codScheduleStatusOld == null;
	}
	
	
	
	private boolean isUnchanged(ScheduleStatus status, ScheduleStatus statusOld) {
		return status == statusOld;
	}
	
	
	
	private SchedovmInfo reverseWaiting(ScheduleStatus status, SchedovmInfo recordInfo) {
		if (ScheduleStatus.WAITING == status) {
			recordInfo.waiting = -1;
			recordInfo.counter = 0;
		}
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo reverseConfirmed(ScheduleStatus status, SchedovmInfo recordInfo) {
		if (ScheduleStatus.CONFIRMED == status) {
			recordInfo.confirmed = -1;
			recordInfo.counter = 0;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
