package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.masterData.info.common.OrderStatusMoip;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterStatusMoip implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		
		OrderStatusMoip status = getMoipStatus(recordInfo);
		
		recordInfo = setDefault(recordInfo);	
		recordInfo = setWaiting(recordInfo, status);
		recordInfo = setPaid(recordInfo, status);
		recordInfo = setNotPaid(recordInfo, status);
		recordInfo = setCancelled(recordInfo, status);
		
		return recordInfo;
	}
	
	
	
	private OrderStatusMoip getMoipStatus(OrderInfo recordInfo) {
		if (recordInfo.statusOrderPartner == null)
			return null;
		
		return OrderStatusMoip.getStatus(recordInfo.statusOrderPartner);
	}
	
	
	
	private OrderInfo setDefault(OrderInfo recordInfo) {
		recordInfo.codOrderStatus = OrderStatus.CREATED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private OrderInfo setWaiting(OrderInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.CREATED || 
		   status == OrderStatusMoip.WAITING	)
			recordInfo.codOrderStatus = OrderStatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrderInfo setPaid(OrderInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.PAID)
			recordInfo.codOrderStatus = OrderStatus.PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrderInfo setNotPaid(OrderInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.NOT_PAID)
			recordInfo.codOrderStatus = OrderStatus.NOT_PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrderInfo setCancelled(OrderInfo recordInfo, OrderStatusMoip status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusMoip.REVERTED)
			recordInfo.codOrderStatus = OrderStatus.CANCELLED.getCodStatus();
		
		return recordInfo;
	}	
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
