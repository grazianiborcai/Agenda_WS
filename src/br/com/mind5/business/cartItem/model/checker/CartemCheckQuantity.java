package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CartemCheckQuantity extends ModelCheckerTemplateSimple_<CartemInfo> {

	public CartemCheckQuantity() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.quantity != 1)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CART_ITEM_QUANTITY_ILLEGAL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CART_ITEM_QUANTITY_ILLEGAL;
	}
}
