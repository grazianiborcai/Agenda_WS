package br.com.gda.business.cart.model.checker;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CartCheckRead extends ModelCheckerTemplateSimple<CartInfo> {

	public CartCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CART_HEADER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CART_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
