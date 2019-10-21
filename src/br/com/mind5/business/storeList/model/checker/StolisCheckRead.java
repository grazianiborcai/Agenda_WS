package br.com.mind5.business.storeList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StolisCheckRead extends ModelCheckerTemplateSimpleV2<StolisInfo> {

	public StolisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StolisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LIST_MANDATORY_FIELD_EMPTY;
	}
}
