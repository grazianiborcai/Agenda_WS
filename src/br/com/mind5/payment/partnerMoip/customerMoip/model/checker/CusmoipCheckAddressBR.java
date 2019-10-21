package br.com.mind5.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Country;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckAddressBR extends ModelCheckerTemplateSimple_<CusmoipInfo> {

	public CusmoipCheckAddressBR() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresnapData.codCountry.equals(Country.BRAZIL.getCodCountry())) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_ADDRESS_BR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_ADDRESS_BR;
	}
}
