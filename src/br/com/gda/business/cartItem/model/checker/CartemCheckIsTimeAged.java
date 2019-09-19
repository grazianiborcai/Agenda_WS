package br.com.gda.business.cartItem.model.checker;

import java.sql.Connection;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.common.TimeAge;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class CartemCheckIsTimeAged extends ModelCheckerTemplateSimple_<CartemInfo> {

	public CartemCheckIsTimeAged() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		if (isAged(recordInfo))			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isAged(CartemInfo recordInfo) {
		return new TimeAge().isAged(recordInfo.date, recordInfo.beginTime);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AGED_DATE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AGED_DATE;
	}
}
