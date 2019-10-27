package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddressData extends ModelCheckerTemplateSimpleV2<CremoipInfo> {

	public CremoipCheckAddressData(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_ADDRESS_MISSING;
	}	
}
