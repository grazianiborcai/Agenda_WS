package br.com.mind5.business.orderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrderemCheckIsCancelled extends ModelCheckerTemplateSimpleV2<OrderemInfo> {

	public OrderemCheckIsCancelled(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrderemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrderStatus == null	)			
			return super.FAILED;		
		
		return isStatusCancelled(recordInfo.codOrderStatus);
	}
	
	
	
	private boolean isStatusCancelled(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.CANCELLED)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_ITEM_IS_CANCELLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_IS_NOT_CANCELLED;
	}
}
