package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class SchedineSetterStatus implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		return setStatus(recordInfo);
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private SchedineInfo setStatus(SchedineInfo recordInfo) {
		OrderStatus status = null;
		
		if (recordInfo.codOrderStatus != null)
			status = OrderStatus.getOrderStatus(recordInfo.codOrderStatus);		
		
		recordInfo = setDefault(recordInfo);
		recordInfo = setConfirmed(recordInfo, status);
		recordInfo = setWaiting(recordInfo, status);
		recordInfo = setCancelled(recordInfo, status);;
		
		return recordInfo;
	}
	
	
	
	private SchedineInfo setDefault(SchedineInfo recordInfo) {
		recordInfo.codScheduleStatus = ScheduleStatus.CONFIRMED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private SchedineInfo setConfirmed(SchedineInfo recordInfo, OrderStatus status) {
		if (status == null)
			return recordInfo;
		
		if (status == OrderStatus.PAID)
			recordInfo.codScheduleStatus = ScheduleStatus.CONFIRMED.getCodStatus();
		
		if (status == OrderStatus.REFUNDING)
			recordInfo.codScheduleStatus = ScheduleStatus.CONFIRMED.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private SchedineInfo setWaiting(SchedineInfo recordInfo, OrderStatus status) {
		if (status == null)
			return recordInfo;
		
		if (status == OrderStatus.CREATED)
			recordInfo.codScheduleStatus = ScheduleStatus.WAITING.getCodStatus();
		
		if (status == OrderStatus.NOT_PAID)
			recordInfo.codScheduleStatus = ScheduleStatus.WAITING.getCodStatus();
		
		if (status == OrderStatus.PLACED)
			recordInfo.codScheduleStatus = ScheduleStatus.WAITING.getCodStatus();
		
		if (status == OrderStatus.WAITING)
			recordInfo.codScheduleStatus = ScheduleStatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private SchedineInfo setCancelled(SchedineInfo recordInfo, OrderStatus status) {
		if (status == null)
			return recordInfo;
		
		if (status == OrderStatus.CANCELLED)
			recordInfo.codScheduleStatus = ScheduleStatus.CANCELLED.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
