package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class UserCategCheckRead extends ModelCheckerTemplateSimple_<UserCategInfo> {
	
	public UserCategCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserCategInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_CATEG_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_CATEG_MANDATORY_FIELD_EMPTY;
	}
}
