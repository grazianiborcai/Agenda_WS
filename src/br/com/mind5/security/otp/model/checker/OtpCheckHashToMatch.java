package br.com.mind5.security.otp.model.checker;

import java.sql.Connection;
import java.util.Arrays;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.otp.info.OtpInfo;

public final class OtpCheckHashToMatch extends ModelCheckerTemplateSimpleV2<OtpInfo> {

	public OtpCheckHashToMatch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OtpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hash 		== null ||
			recordInfo.hashToMatch	== null		)			
			
			return super.FAILED;
		
		
		if (Arrays.equals(recordInfo.hash, recordInfo.hashToMatch))
			return super.SUCCESS;
		
		
		return FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.OTP_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_IS_INVALID;
	}
}
