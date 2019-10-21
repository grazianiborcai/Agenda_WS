package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CartemCheckWriteL3 extends ModelCheckerTemplateSimple_<CartemInfo> {

	public CartemCheckWriteL3() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codUser		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codEmployee	<= 0
			|| recordInfo.codMat		<= 0
			|| recordInfo.quantity		<= 0
			|| recordInfo.beginTime		== null
			|| recordInfo.endTime		== null
			|| recordInfo.date			== null	)
			
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
