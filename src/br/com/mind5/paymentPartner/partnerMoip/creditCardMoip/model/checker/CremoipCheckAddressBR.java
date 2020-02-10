package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Country;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddressBR extends ModelCheckerTemplateSimpleV2<CremoipInfo> {

	public CremoipCheckAddressBR(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressData == null)
			return super.FAILED;
		
		
		if (recordInfo.addressData.codCountry == null)
			return super.FAILED;
		
		
		if (recordInfo.addressData.codCountry.equals(Country.BRAZIL.getCodCountry())) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_ADDRESS_BR;
	}
}
