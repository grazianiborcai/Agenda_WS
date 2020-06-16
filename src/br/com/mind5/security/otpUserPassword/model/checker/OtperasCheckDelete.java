package br.com.mind5.security.otpUserPassword.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasCheckDelete extends ModelCheckerTemplateSimpleV2<OtperasInfo> {

	public OtperasCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OtperasInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 	<= 0 	
			|| recordInfo.codUser 	<= 0	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_USER_PASSWORD_MANDATORY_FIELD_EMPTY;
	}
}
