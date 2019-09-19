package br.com.gda.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.Country;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

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
