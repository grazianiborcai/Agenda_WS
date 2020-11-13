package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;
import java.util.Arrays;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckHashToMatch extends ModelCheckerTemplateSimple<UpswdInfo> {

	public UpswdCheckHashToMatch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hash 		== null ||
			recordInfo.hashToMatch	== null		)			
			
			return super.FAILED;
		
		
		if (Arrays.equals(recordInfo.hash, recordInfo.hashToMatch))
			return super.SUCCESS;
		
		
		return FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PASSWORD_AND_USERNAME_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
