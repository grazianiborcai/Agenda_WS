package br.com.mind5.business.planningTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PlanimeCheckRead extends ModelCheckerTemplateSimpleV2<PlanimeInfo> {

	public PlanimeCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PlanimeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.dates == null)			
			return super.FAILED;		
		
		
		if (recordInfo.dates.isEmpty())			
			return super.FAILED;		
		

		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)					
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PLAN_TIME_MANDATORY_FIELD_EMPTY;
	}
}
