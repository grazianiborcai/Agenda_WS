package br.com.mind5.business.storeManager.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StomanCheckRead extends ModelCheckerTemplateSimple<StomanInfo> {

	public StomanCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StomanInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.codUser 		<= 0 	||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_MANAGER_MANDATORY_FIELD_EMPTY;
	}
}
