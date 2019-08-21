package br.com.gda.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.OrderStatus;
import br.com.gda.business.masterData.info.common.ScheduleStatus;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		recordInfo = setDefault(recordInfo);
		recordInfo = setFromOrder(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private SchedineInfo setDefault(SchedineInfo recordInfo) {
		recordInfo.codScheduleStatus = ScheduleStatus.CONFIRMED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private SchedineInfo setFromOrder(SchedineInfo recordInfo) {
		if (recordInfo.codOrderStatus == null)
			return recordInfo;
		
		recordInfo.codScheduleStatus = ScheduleStatus.WAITING.getCodStatus();
		OrderStatus status = OrderStatus.getOrderStatus(recordInfo.codOrderStatus);
		
		if (status == OrderStatus.PAID)
			recordInfo.codScheduleStatus = ScheduleStatus.CONFIRMED.getCodStatus();
		
		if (status == OrderStatus.CANCELLED)
			recordInfo.codScheduleStatus = ScheduleStatus.CANCELLED.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
