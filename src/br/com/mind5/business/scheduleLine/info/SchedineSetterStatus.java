package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.orderStatus.info.Orderatus;
import br.com.mind5.masterData.scheduleStatus.info.Schedatus;

public final class SchedineSetterStatus extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		Orderatus status = null;
		
		if (recordInfo.codOrderStatus != null)
			status = Orderatus.getOrderStatus(recordInfo.codOrderStatus);		
		
		recordInfo = setDefault(recordInfo);
		recordInfo = setConfirmed(recordInfo, status);
		recordInfo = setWaiting(recordInfo, status);
		recordInfo = setCancelled(recordInfo, status);;

		return recordInfo;
	}
	
	
	
	private SchedineInfo setDefault(SchedineInfo recordInfo) {
		recordInfo.codScheduleStatus = Schedatus.CONFIRMED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private SchedineInfo setConfirmed(SchedineInfo recordInfo, Orderatus status) {
		if (status == null)
			return recordInfo;
		
		if (status == Orderatus.PAID)
			recordInfo.codScheduleStatus = Schedatus.CONFIRMED.getCodStatus();
		
		if (status == Orderatus.REFUNDING)
			recordInfo.codScheduleStatus = Schedatus.CONFIRMED.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private SchedineInfo setWaiting(SchedineInfo recordInfo, Orderatus status) {
		if (status == null)
			return recordInfo;
		
		if (status == Orderatus.CREATED)
			recordInfo.codScheduleStatus = Schedatus.WAITING.getCodStatus();
		
		if (status == Orderatus.NOT_PAID)
			recordInfo.codScheduleStatus = Schedatus.WAITING.getCodStatus();
		
		if (status == Orderatus.PLACED)
			recordInfo.codScheduleStatus = Schedatus.WAITING.getCodStatus();
		
		if (status == Orderatus.WAITING)
			recordInfo.codScheduleStatus = Schedatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private SchedineInfo setCancelled(SchedineInfo recordInfo, Orderatus status) {
		if (status == null)
			return recordInfo;
		
		if (status == Orderatus.CANCELLED)
			recordInfo.codScheduleStatus = Schedatus.CANCELLED.getCodStatus();
		
		return recordInfo;
	}
}
