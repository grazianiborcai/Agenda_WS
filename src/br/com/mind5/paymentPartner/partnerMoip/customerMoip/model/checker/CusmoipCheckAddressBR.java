package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Country;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckAddressBR extends ModelCheckerTemplateSimpleV2<CusmoipInfo> {

	public CusmoipCheckAddressBR(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addressData == null)
			return super.FAILED;
		
		
		if (recordInfo.addressData.codCountry == null)
			return super.FAILED;
		
		
		if (recordInfo.addressData.codCountry.equals(Country.BRAZIL.getCodCountry())) 
			return super.SUCCESS;

		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_ADDRESS_BR;
	}
}
