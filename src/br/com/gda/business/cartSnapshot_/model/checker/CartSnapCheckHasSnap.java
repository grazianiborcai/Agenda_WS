package br.com.gda.business.cartSnapshot_.model.checker;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CartSnapCheckHasSnap extends ModelCheckerTemplateSimple<CartSnapInfo> {

	public CartSnapCheckHasSnap() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartSnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codSnapshot	<= 0 )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CART_SNAPSHOT_IS_NULL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CART_SNAPSHOT_IS_NULL;
	}
}
