package br.com.gda.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.CountryPhone;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckPhoneBR extends ModelCheckerTemplateSimple_<CusmoipInfo> {

	public CusmoipCheckPhoneBR() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phonapData.codCountryPhone == CountryPhone.BRAZIL.getCodCountryPhone()) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_PHONE_BR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_PHONE_BR;
	}
}
