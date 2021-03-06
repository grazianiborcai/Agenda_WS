package br.com.mind5.message.emailUserOtp.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmusotpCheckSend extends ModelCheckerTemplateSimple<EmusotpInfo> {

	public EmusotpCheckSend(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmusotpInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner	<= 0	||
			 recordInfo.password	== null	||
			 recordInfo.codLanguage	== null		)		
			
			return super.FAILED;
		
		
		if ( recordInfo.persolisData == null )
			return super.FAILED;
		
		
		if ( recordInfo.persolisData.name == null	)		
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMAIL_USER_OTP_MANDATORY_FIELD_EMPTY;
	}
}
