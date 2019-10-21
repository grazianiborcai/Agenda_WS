package br.com.mind5.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckAddresnapData extends ModelCheckerTemplateSimple_<CusmoipInfo> {

	public CusmoipCheckAddresnapData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresnapData == null)
			return super.FAILED;
		
		
		if (recordInfo.addresnapData.city			== null ||
			recordInfo.addresnapData.district 		== null	||
			recordInfo.addresnapData.street			== null ||
			recordInfo.addresnapData.streetNumber 	== null	||
			recordInfo.addresnapData.txtState 		== null	||
		  //recordInfo.addresnapData.txtCountry 	== null	||
			recordInfo.addresnapData.postalCode 	== null)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_ADDRESNAP_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_ADDRESNAP_MISSING;
	}
}
