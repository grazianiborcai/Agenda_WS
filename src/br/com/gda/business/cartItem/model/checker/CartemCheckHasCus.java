package br.com.gda.business.cartItem.model.checker;

import java.sql.Connection;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CartemCheckHasCus extends ModelCheckerTemplateSimple<CartemInfo> {

	public CartemCheckHasCus() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner <= 0 || recordInfo.codCustomer	<= 0 )
			
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
