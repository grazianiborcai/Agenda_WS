package br.com.mind5.business.orderStatusChange.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.OrderStatusPagarme;
import br.com.mind5.masterData.orderStatus.info.Orderatus;

public final class OrdugeSetterPagarme extends InfoSetterTemplate<OrdugeInfo> {
	
	@Override protected OrdugeInfo setAttrHook(OrdugeInfo recordInfo) {
		OrderStatusPagarme status = getPagarmeStatus(recordInfo);
		
		recordInfo = setDefault(recordInfo);	
		recordInfo = setWaiting(recordInfo, status);
		recordInfo = setPaid(recordInfo, status);
		recordInfo = setNotPaid(recordInfo, status);
		recordInfo = setCancelled(recordInfo, status);
		
		return recordInfo;
	}
	
	
	
	private OrderStatusPagarme getPagarmeStatus(OrdugeInfo recordInfo) {
		if (recordInfo.statusOrderPartner == null)
			return null;
		
		return OrderStatusPagarme.getStatus(recordInfo.statusOrderPartner);
	}
	
	
	
	private OrdugeInfo setDefault(OrdugeInfo recordInfo) {
		recordInfo.codOrderStatusNew = Orderatus.CREATED.getCodStatus();
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setWaiting(OrdugeInfo recordInfo, OrderStatusPagarme status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusPagarme.CREATED || 
		   status == OrderStatusPagarme.WAITING)
			recordInfo.codOrderStatusNew = Orderatus.WAITING.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setPaid(OrdugeInfo recordInfo, OrderStatusPagarme status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusPagarme.PAID)
			recordInfo.codOrderStatusNew = Orderatus.PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setNotPaid(OrdugeInfo recordInfo, OrderStatusPagarme status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusPagarme.NOT_PAID ||
		   status == OrderStatusPagarme.FAILED		)
			recordInfo.codOrderStatusNew = Orderatus.NOT_PAID.getCodStatus();
		
		return recordInfo;
	}
	
	
	
	private OrdugeInfo setCancelled(OrdugeInfo recordInfo, OrderStatusPagarme status) {
		if (status == null)
			return recordInfo;
		
		if(status == OrderStatusPagarme.CANCELED)
			recordInfo.codOrderStatusNew = Orderatus.CANCELLED.getCodStatus();
		
		return recordInfo;
	}
}
