package br.com.gda.business.orderItem.model.checker;

import java.sql.Connection;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class OrderemCheckIsService extends ModelCheckerTemplateSimple_<OrderemInfo> {

	public OrderemCheckIsService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderemInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.matData == null)
			return super.FAILED;
		
		if (recordInfo.matData.codMatCateg == MatCateg.SERVICE.getCodMatCateg())
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_ITEM_IS_NOT_SERVICE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_ITEM_IS_NOT_SERVICE;
	}
}
