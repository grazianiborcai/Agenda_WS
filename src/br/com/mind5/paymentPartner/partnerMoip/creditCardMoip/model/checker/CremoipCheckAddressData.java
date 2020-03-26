package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddressData extends ModelCheckerTemplateSimple<CremoipInfo> {

	public CremoipCheckAddressData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresnapData == null)
			return super.FAILED;
		
		
		if (recordInfo.addresnapData.city			== null ||
			recordInfo.addresnapData.district 		== null	||
			recordInfo.addresnapData.street			== null ||
			recordInfo.addresnapData.streetNumber 	== null	||
		    recordInfo.addresnapData.txtState 		== null	||
			recordInfo.addresnapData.postalCode 	== null		)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_ADDRESS_MISSING;
	}	
}
