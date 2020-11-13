package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckHasPerson extends ModelCheckerTemplateSimple<UserInfo> {
	
	public UserCheckHasPerson(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPerson <= 0)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PERSON_IS_FILLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PERSON_IS_NULL;
	}
}
