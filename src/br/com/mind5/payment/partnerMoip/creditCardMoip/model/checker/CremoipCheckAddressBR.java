package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Country;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddressBR extends ModelCheckerTemplateSimple_<CremoipInfo> {

	public CremoipCheckAddressBR() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressData.codCountry.equals(Country.BRAZIL.getCodCountry())) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MOIP_ADDRESS_BR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MOIP_ADDRESS_BR;
	}
}
