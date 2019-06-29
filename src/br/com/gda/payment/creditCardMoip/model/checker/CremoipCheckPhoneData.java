package br.com.gda.payment.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckPhoneData extends ModelCheckerTemplateSimple<CremoipInfo> {

	public CremoipCheckPhoneData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phoneData == null)
			return super.FAILED;
		
		
		if (recordInfo.phoneData.codCountryPhone	<= 0 	||
			recordInfo.phoneData.fullNumber			== null		)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MOIP_PHONE_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MOIP_PHONE_MISSING;
	}
}
