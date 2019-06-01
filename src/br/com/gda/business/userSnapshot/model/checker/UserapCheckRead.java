package br.com.gda.business.userSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserapCheckRead extends ModelCheckerTemplateSimple<UserapInfo> {

	public UserapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codSnapshot 	<= 0 	||
			recordInfo.username 	== null	||
			recordInfo.codLanguage 	== null		)			
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
