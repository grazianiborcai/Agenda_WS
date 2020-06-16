package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;

public final class SchedovmSetterCounter extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
		Schedatus status = Schedatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		recordInfo = setWaiting(status, recordInfo);
		recordInfo = setConfirmed(status, recordInfo);
		recordInfo = setCount(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setWaiting(Schedatus status, SchedovmInfo recordInfo) {
		recordInfo.waiting = 0;
		
		if (Schedatus.WAITING == status) 
			recordInfo.waiting = 1;
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setConfirmed(Schedatus status, SchedovmInfo recordInfo) {
		recordInfo.confirmed = 0;
		
		if (Schedatus.CONFIRMED == status) 
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
