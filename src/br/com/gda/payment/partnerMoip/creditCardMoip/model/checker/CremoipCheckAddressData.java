package br.com.gda.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddressData extends ModelCheckerTemplateSimple<CremoipInfo> {

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
