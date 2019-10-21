package br.com.mind5.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckPhonapData extends ModelCheckerTemplateSimple_<CusmoipInfo> {

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
