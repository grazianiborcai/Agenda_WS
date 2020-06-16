package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;

public final class SchedovmSetterCancel extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
		Schedatus status = Schedatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		if (isCancelled(status) == false)
			return recordInfo;
		
		Schedatus statusOld = Schedatus.getScheduleStatus(recordInfo.codScheduleStatusOld); 
		
		recordInfo = cancelWaiting(statusOld, recordInfo);
		recordInfo = cancelConfirmed(statusOld, recordInfo);
		
		return recordInfo;
	}
	
	
	
	private boolean isCancelled(Schedatus status) {
		return Schedatus.CANCELLED == status;
	}
	
	
	
	private SchedovmInfo cancelWaiting(Schedatus status, SchedovmInfo recordInfo) {
		if (Schedatus.WAITING == status) {
			recordInfo.waiting = -1;
			recordInfo.counter = -1;
		}
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo cancelConfirmed(Schedatus status, SchedovmInfo recordInfo) {
		if (Schedatus.CONFIRMED == status) {
			recordInfo.confirmed = -1;
			recordInfo.counter = -1;
		}
		
		return recordInfo;
	}
}
