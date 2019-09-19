package br.com.gda.business.cartItem.model.checker;

import java.sql.Connection;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CartemCheckIsDeleted extends ModelCheckerTemplateSimple_<CartemInfo> {

	public CartemCheckIsDeleted() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.isDeleted)
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CART_ITEM_IS_NOT_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CART_ITEM_IS_NOT_DELETED;
	}
}
