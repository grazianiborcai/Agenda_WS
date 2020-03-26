package br.com.mind5.business.storeWorkTimeRange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoworgCheckRead extends ModelCheckerTemplateSimple<StoworgInfo> {

	public StoworgCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoworgInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.codWeekday 	<= 0 	||
			recordInfo.beginTime 	== null ||
			recordInfo.endTime 		== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_RANGE_MANDATORY_FIELD_EMPTY;
	}
}
