package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckPersonData extends ModelCheckerTemplateSimple<UserInfo> {
	
	public UserCheckPersonData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.personData == null)			
			return super.FAILED;		
		
		if (recordInfo.personData.email == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_EMAIL_IS_NULL;
	}
}
