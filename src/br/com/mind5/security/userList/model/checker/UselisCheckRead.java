package br.com.mind5.security.userList.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisCheckRead extends ModelCheckerTemplateSimple_<UselisInfo> {

	public UselisCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UselisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)			
			return super.FAILED;	
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_LIST_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_LIST_MANDATORY_FIELD_EMPTY;
	}
}
