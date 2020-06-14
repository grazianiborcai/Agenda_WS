package br.com.mind5.security.otp.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.otp.info.OtpInfo;

public final class OtpCheckValidate extends ModelCheckerTemplateSimpleV2<OtpInfo> {

	public OtpCheckValidate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OtpInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.password 	== null ||
			 recordInfo.validUntil 	== null	||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_MANDATORY_FIELD_EMPTY;
	}
}
