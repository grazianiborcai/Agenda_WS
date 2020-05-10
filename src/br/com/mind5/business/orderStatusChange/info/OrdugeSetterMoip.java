package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrdugeSetterMoip extends InfoSetterTemplate<OrdugeInfo> {
	
	@Override protected OrdugeInfo setAttrHook(OrdugeInfo recordInfo) {
		OrderStatusMoip status = getMoipStatus(recordInfo);
		
		recordInfo = setDefault(recordInfo);	
		recordInfo = setWaiting(recordInfo, status);
		recordInfo = setPaid(recordInfo, status);
		recordInfo = setNotPaid(recordInfo, status);
		recordInfo = setCancelled(recordInfo, status);
		
		return recordInfo;
	}
	
	
	
	private OrderStatusMoip getMoipStatus(OrdugeInfo recordInfo) {
		if (recordInfo.statusOrderPartner == null)
			return null;
		
		return OrderStatusMoip.getStatus(recordInfo.statusOrderPartner);
	}
	
	
	
	private OrdugeInfo setDefault(OrdugeInfo recordInfo) {
		recordInfo.codOrderStatusNew = OrderStatus.CREATED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setWaiting(OrdugeInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.CREATED || 
		   status == OrderStatusMoip.WAITING	)
			recordInfo.codOrderStatusNew = OrderStatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setPaid(OrdugeInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.PAID)
			recordInfo.codOrderStatusNew = OrderStatus.PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setNotPaid(OrdugeInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.NOT_PAID)
			recordInfo.codOrderStatusNew = OrderStatus.NOT_PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setCancelled(OrdugeInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.REVERTED)
			recordInfo.codOrderStatusNew = OrderStatus.CANCELLED.getCodStatus();
		
		return recordInfo;
	}	
}
