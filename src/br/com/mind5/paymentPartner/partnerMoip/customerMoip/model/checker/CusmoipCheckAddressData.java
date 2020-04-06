package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckAddressData extends ModelCheckerTemplateSimpleV2<CusmoipInfo> {

	public CusmoipCheckAddressData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresnapData == null)
			return super.FAILED;
		
		
		if (recordInfo.addresnapData.city				== null ||
			recordInfo.addresnapData.district 		== null	||
			recordInfo.addresnapData.street			== null ||
			recordInfo.addresnapData.streetNumber 	== null	||
			recordInfo.addresnapData.txtState 		== null	||
		  //recordInfo.addresnapData.txtCountry 	== null	||
			recordInfo.addresnapData.postalCode 		== null)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_MOIP_ADDRESNAP_MISSING;
	}
}
