package br.com.mind5.business.scheduleMoviment.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;

public final class SchedovmSetterReverse extends InfoSetterTemplate<SchedovmInfo> {
	
	@Override protected SchedovmInfo setAttrHook(SchedovmInfo recordInfo) {
		if (isStatusOldEmpty(recordInfo))
			return recordInfo;
		
		
		Schedatus status = Schedatus.getScheduleStatus(recordInfo.codScheduleStatus); 
		
		if (isCancelled(status))
			return recordInfo;
		
		
		Schedatus statusOld = Schedatus.getScheduleStatus(recordInfo.codScheduleStatusOld); 		
		
		if (isUnchanged(status, statusOld)) 
			return recordInfo;
		
		
		
		recordInfo = reverseWaiting(statusOld, recordInfo);
		recordInfo = reverseConfirmed(statusOld, recordInfo);
		
		return recordInfo;
	}
	
	
	
	private boolean isCancelled(Schedatus status) {
		return Schedatus.CANCELLED == status;
	}
	
	
	
	private boolean isStatusOldEmpty(SchedovmInfo recordInfo) {		
		return recordInfo.codScheduleStatusOld == null;
	}
	
	
	
	private boolean isUnchanged(Schedatus status, Schedatus statusOld) {
		return status == statusOld;
	}
	
	
	
	private SchedovmInfo reverseWaiting(Schedatus status, SchedovmInfo recordInfo) {
		if (Schedatus.WAITING == status) {
			recordInfo.waiting = -1;
			recordInfo.counter = 0;
		}
		
		return recordInfo;
	}
	
	
	
	private SchedovmInfo reverseConfirmed(Schedatus status, SchedovmInfo recordInfo) {
		if (Schedatus.CONFIRMED == status) {
			recordInfo.confirmed = -1;
			recordInfo.counter = 0;
		}
		
		return recordInfo;
	}
}
