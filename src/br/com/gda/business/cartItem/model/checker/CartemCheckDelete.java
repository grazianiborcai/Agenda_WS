package br.com.gda.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CartemCheckDelete extends ModelCheckerTemplateSimple_<CartemInfo> {

	public CartemCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 || 
			 recordInfo.codCustomer	<= 0 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CART_ITEM_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CART_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
