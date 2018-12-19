package br.com.gda.business.cart.model.checker;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CartCheckWriteL3 extends ModelCheckerTemplateSimple<CartInfo> {

	public CartCheckWriteL3() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codUser		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codEmployee	<= 0
			|| recordInfo.codMat		<= 0
			|| recordInfo.quantity		<= 0
			|| recordInfo.beginTime		== null
			|| recordInfo.endTime		== null
			|| recordInfo.date			== null	)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
