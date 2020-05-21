package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.info.InfoSetterTemplate;

public final class SchedovmSetterZero extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
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
}
