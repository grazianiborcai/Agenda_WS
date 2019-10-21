package br.com.mind5.business.cart.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CartCheckCheckout extends ModelCheckerTemplateSimple_<CartInfo> {

	public CartCheckCheckout() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage 	== null )
			
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
