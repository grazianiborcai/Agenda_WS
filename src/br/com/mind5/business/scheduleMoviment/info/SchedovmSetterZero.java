package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;

public final class SchedovmSetterZero extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
		Schedatus status = Schedatus.getScheduleStatus(recordInfo.codScheduleStatus); 		
		Schedatus statusOld = null; 
		
		if (recordInfo.codScheduleStatus != null)
			statusOld = Schedatus.getScheduleStatus(recordInfo.codScheduleStatusOld); 
		
		recordInfo = setZero(status, statusOld, recordInfo);
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo setZero(Schedatus status, Schedatus statusOld, SchedovmInfo recordInfo) {
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
