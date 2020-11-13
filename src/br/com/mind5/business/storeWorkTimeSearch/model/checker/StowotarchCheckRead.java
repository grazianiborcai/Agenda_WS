package br.com.mind5.business.storeWorkTimeSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StowotarchCheckRead extends ModelCheckerTemplateSimple<StowotarchInfo> {

	public StowotarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StowotarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
