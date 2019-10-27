package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.CountryPhone;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckPhoneBR extends ModelCheckerTemplateSimpleV2<CremoipInfo> {

	public CremoipCheckPhoneBR(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.phoneData == null)
			return super.FAILED;
		
		
		if(recordInfo.phoneData.codCountryPhone < 0)
			return super.FAILED;
		
		
		if (recordInfo.phoneData.codCountryPhone == CountryPhone.BRAZIL.getCodCountryPhone()) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_PHONE_BR;
	}	
}
