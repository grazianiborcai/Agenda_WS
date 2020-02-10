package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckPhoneData extends ModelCheckerTemplateSimpleV2<CremoipInfo> {

	public CremoipCheckPhoneData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phoneData == null)
			return super.FAILED;
		
		
		if (recordInfo.phoneData.codCountryPhone	<= 0 	||
			recordInfo.phoneData.fullNumber			== null		)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_PHONE_MISSING;
	}
}
