package br.com.gda.security.userList.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.security.userList.info.UselisInfo;

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
