package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedovmSetterCounter extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
		ScheduleStatus status = ScheduleStatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		recordInfo = setWaiting(status, recordInfo);
		recordInfo = setConfirmed(status, recordInfo);
		recordInfo = setCount(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setWaiting(ScheduleStatus status, SchedovmInfo recordInfo) {
		recordInfo.waiting = 0;
		
		if (ScheduleStatus.WAITING == status) 
			recordInfo.waiting = 1;
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setConfirmed(ScheduleStatus status, SchedovmInfo recordInfo) {
		recordInfo.confirmed = 0;
		
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
}
