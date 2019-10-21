package br.com.mind5.business.planingData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class PlanataCheckReserve_ extends ModelCheckerTemplateSimple_<PlanataInfo> {

	public PlanataCheckReserve_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PlanataInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.codMat 		<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.date 		== null	||
			recordInfo.beginTime	== null	||
			recordInfo.endTime		== null)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
