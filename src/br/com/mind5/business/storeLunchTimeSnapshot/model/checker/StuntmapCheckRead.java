package br.com.mind5.business.storeLunchTimeSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StuntmapCheckRead extends ModelCheckerTemplateSimple<StuntmapInfo> {

	public StuntmapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StuntmapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codSnapshot 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LTIME_SNAPHOT_MANDATORY_FIELD_EMPTY;
	}
}
