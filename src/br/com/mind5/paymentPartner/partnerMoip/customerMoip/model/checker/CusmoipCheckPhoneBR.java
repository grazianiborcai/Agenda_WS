package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.CountryPhone;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckPhoneBR extends ModelCheckerTemplateSimpleV2<CusmoipInfo> {

	public CusmoipCheckPhoneBR(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phoneData == null) 
			return super.FAILED;
		
		
		if (recordInfo.phoneData.codCountryPhone < 0) 
			return super.FAILED;
		
		
		if (recordInfo.phoneData.codCountryPhone == CountryPhone.BRAZIL.getCodCountryPhone()) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_PHONE_BR;
	}
}
