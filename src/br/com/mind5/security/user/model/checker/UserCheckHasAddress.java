package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckHasAddress extends ModelCheckerTemplateSimple_<UserInfo> {
	
	public UserCheckHasAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresses == null || recordInfo.addresses.isEmpty())			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.ADDRESS_IS_NULL)
			return SystemMessage.ADDRESS_IS_NULL;
		
		return SystemMessage.ADDRESS_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.ADDRESS_IS_FILLED;	
			
		return SystemCode.ADDRESS_IS_NULL;
	}
}
