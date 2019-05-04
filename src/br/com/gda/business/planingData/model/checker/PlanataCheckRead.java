package br.com.gda.business.planingData.model.checker;

import java.sql.Connection;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PlanataCheckRead extends ModelCheckerTemplateSimple<PlanataInfo> {

	public PlanataCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PlanataInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 	||
			recordInfo.date 	== null		)			
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
