package br.com.mind5.business.orderStatusChange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.OrderStatus;
import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OrdugeCheckRefunding extends ModelCheckerTemplateSimpleV2<OrdugeInfo> {

	public OrdugeCheckRefunding(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdugeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatusOld == null)
			return super.FAILED;	
		
		if (isStatusPaid(recordInfo.codOrderStatusOld))
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusPaid(String codOrderStatus) {		
		OrderStatus status = OrderStatus.getOrderStatus(codOrderStatus);
		
		if(status == OrderStatus.PAID)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_HEADER_STATUS_CHANGE_NOT_ALLOWED;
	}
}
