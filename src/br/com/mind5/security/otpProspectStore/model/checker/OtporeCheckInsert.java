package br.com.mind5.security.otpProspectStore.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class OtporeCheckInsert extends ModelCheckerTemplateSimple<OtporeInfo> {

	public OtporeCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OtporeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.prospectEmail	== null	||
			 recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_PROSP_STORE_MANDATORY_FIELD_EMPTY;
	}
}
