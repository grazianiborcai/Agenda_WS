package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.masterData.info.common.MatCateg;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CartemCheckIsService extends ModelCheckerTemplateSimple_<CartemInfo> {

	public CartemCheckIsService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.matData == null)
			return super.FAILED;
		
		if (recordInfo.matData.codMatCateg == MatCateg.SERVICE.getCodMatCateg())
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
