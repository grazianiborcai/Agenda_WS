package br.com.mind5.security.userSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UserarchCheckReadAuth extends ModelCheckerTemplateSimpleV2<UserarchInfo> {

	public UserarchCheckReadAuth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UserarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username		== null		)		
			
			return super.FAILED;	

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
