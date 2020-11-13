package br.com.mind5.security.otp.model.checker;

import java.sql.Connection;
import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.otp.info.OtpInfo;

public final class OtpCheckExpiry extends ModelCheckerTemplateSimple<OtpInfo> {

	public OtpCheckExpiry(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OtpInfo recordInfo, Connection conn, String schemaName) {	
		LocalDateTime now = DefaultValue.localDateTimeNow();
		
		if (recordInfo.validUntil == null) 
			return super.FAILED;

		if (recordInfo.validUntil.isBefore(now)) 
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_IS_EXPIRED;
	}
}
