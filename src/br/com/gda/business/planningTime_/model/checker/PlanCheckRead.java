package br.com.gda.business.planningTime_.model.checker;

import java.sql.Connection;

import br.com.gda.business.planningTime_.info.PlanDataInfo;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PlanCheckRead extends ModelCheckerTemplateSimple<PlanInfo> {

	public PlanCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PlanInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.datas == null || recordInfo.datas.isEmpty())			
			return FAILED;
		
		
		for (PlanDataInfo eachData: recordInfo.datas) {
			if ( eachData.codOwner 	<= 0	||
				 eachData.date		== null		)				
				return FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
