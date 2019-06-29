package br.com.gda.payment.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckAddresnapData extends ModelCheckerTemplateSimple<CusmoipInfo> {

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
