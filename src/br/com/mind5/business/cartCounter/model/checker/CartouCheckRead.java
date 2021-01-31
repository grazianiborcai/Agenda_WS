package br.com.mind5.business.cartCounter.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CartouCheckRead extends ModelCheckerTemplateSimple<CartouInfo> {

	public CartouCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartouInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_COUNTER_MANDATORY_FIELD_EMPTY;
	}
}
