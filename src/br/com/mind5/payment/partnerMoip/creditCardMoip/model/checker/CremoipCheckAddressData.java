package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddressData extends ModelCheckerTemplateSimple_<CremoipInfo> {

	public CremoipCheckAddressData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressData == null)
			return super.FAILED;
		
		
		if (recordInfo.addressData.city			== null ||
			recordInfo.addressData.district 	== null	||
			recordInfo.addressData.street		== null ||
			recordInfo.addressData.streetNumber == null	||
		    recordInfo.addressData.txtState 	== null	||
			recordInfo.addressData.postalCode 	== null)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MOIP_ADDRESS_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MOIP_ADDRESS_MISSING;
	}
}
