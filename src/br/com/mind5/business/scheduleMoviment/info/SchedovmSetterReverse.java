package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedovmSetterReverse extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
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
}
