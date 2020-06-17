package br.com.mind5.security.userPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckUpdateAuth extends ModelCheckerTemplateSimpleV2<UpswdInfo> {

	public UpswdCheckUpdateAuth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UpswdInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.password	== null	||
			 recordInfo.username	== null	||
			 recordInfo.otpPassword	== null	||
			 recordInfo.codLanguage	== null)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_MANDATORY_FIELD_EMPTY;
	}
}
