package br.com.mind5.business.orderStatusChange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.orderStatus.info.Orderatus;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class OrdugeCheckPay extends ModelCheckerTemplateSimple<OrdugeInfo> {

	public OrdugeCheckPay(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdugeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrderStatusOld == null)
			return super.FAILED;		
		
		if (isStatusPlaced(recordInfo.codOrderStatusOld))
			return super.SUCCESS;
		
		if (isStatusNotPaid(recordInfo.codOrderStatusOld))
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusPlaced(String codOrderStatus) {		
		Orderatus status = Orderatus.getOrderStatus(codOrderStatus);
		
		if(status == Orderatus.PLACED)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusNotPaid(String codOrderStatus) {		
		Orderatus status = Orderatus.getOrderStatus(codOrderStatus);
		
		if(status == Orderatus.NOT_PAID)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_STATUS_CHANGE_NOT_ALLOWED;
	}
}
