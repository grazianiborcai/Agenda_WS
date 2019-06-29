package br.com.gda.payment.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckPhonapData extends ModelCheckerTemplateSimple<CusmoipInfo> {

	public CusmoipCheckPhonapData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phonapData == null)
			return super.FAILED;
		
		
		if (recordInfo.phonapData.codCountryPhone	<= 0 	||
			recordInfo.phonapData.fullNumber		== null		)	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_PHONAP_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_PHONAP_MISSING;
	}
}
