package br.com.gda.business.planningTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PlanimeCheckRead extends ModelCheckerTemplateSimple_<PlanimeInfo> {

	public PlanimeCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PlanimeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.dates == null 	|| 
			recordInfo.dates.isEmpty()		)			
			return super.FAILED;		
		

		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)					
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
