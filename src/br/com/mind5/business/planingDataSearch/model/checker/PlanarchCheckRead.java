package br.com.mind5.business.planingDataSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PlanarchCheckRead extends ModelCheckerTemplateSimpleV2<PlanarchInfo> {

	public PlanarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PlanarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.date 		== null	||
		    recordInfo.codStore 	<= 0 	||
			recordInfo.codEmployee	<= 0	||
			recordInfo.codMat		<= 0	||	
			recordInfo.beginTimeSel == null	||
			recordInfo.endTimeSel 	== null		)			
				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PLAN_DATA_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
