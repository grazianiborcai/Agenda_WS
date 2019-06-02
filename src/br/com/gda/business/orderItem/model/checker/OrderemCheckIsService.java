package br.com.gda.business.orderItem.model.checker;

import java.sql.Connection;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class OrderemCheckIsService extends ModelCheckerTemplateSimple<OrderemInfo> {

	public OrderemCheckIsService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrderemInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.matInfo == null)
			return super.FAILED;
		
		if (recordInfo.matInfo.codMatCateg == MatCateg.SERVICE.getCodMatCateg())
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CART_ITEM_IS_NOT_SERVICE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CART_ITEM_IS_NOT_SERVICE;
	}
}
