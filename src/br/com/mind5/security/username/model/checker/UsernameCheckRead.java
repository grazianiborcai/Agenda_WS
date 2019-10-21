package br.com.mind5.security.username.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UsernameCheckRead extends ModelCheckerTemplateSimple_<UsernameInfo> {

	public UsernameCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UsernameInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 	||
			recordInfo.username	== null		)			
				return FAILED;	
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
