package br.com.mind5.security.userSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapCheckWrite extends ModelCheckerTemplateSimple_<UserapInfo> {

	public UserapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserapInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	<= 0 
			 || recordInfo.codUser		<= 0
			 || recordInfo.username		== null
			 || recordInfo.codLanguage	== null	)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
