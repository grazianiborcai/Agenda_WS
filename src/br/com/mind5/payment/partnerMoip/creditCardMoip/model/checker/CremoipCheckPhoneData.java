package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckPhoneData extends ModelCheckerTemplateSimple_<CremoipInfo> {

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
