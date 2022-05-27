package br.com.mind5.business.storeProspectCounter.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoprosouCheckRead extends ModelCheckerTemplateSimple<StoprosouInfo> {

	public StoprosouCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoprosouInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PROSPECT_COUNT_MANDATORY_FIELD_EMPTY;
	}
}
