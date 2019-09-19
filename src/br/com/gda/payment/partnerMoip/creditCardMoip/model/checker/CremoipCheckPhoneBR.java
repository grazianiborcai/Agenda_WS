package br.com.gda.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.CountryPhone;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckPhoneBR extends ModelCheckerTemplateSimple_<CremoipInfo> {

	public CremoipCheckPhoneBR() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phoneData.codCountryPhone == CountryPhone.BRAZIL.getCodCountryPhone()) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MOIP_PHONE_BR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MOIP_PHONE_BR;
	}
}
