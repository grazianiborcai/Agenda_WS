package br.com.mind5.security.otpUserPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasCheckInsert extends ModelCheckerTemplateSimple<OtperasInfo> {

	public OtperasCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OtperasInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_USER_PASSWORD_MANDATORY_FIELD_EMPTY;
	}
}
