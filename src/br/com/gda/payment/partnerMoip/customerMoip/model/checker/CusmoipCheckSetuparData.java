package br.com.gda.payment.partnerMoip.customerMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckSetuparData extends ModelCheckerTemplateSimple_<CusmoipInfo> {

	public CusmoipCheckSetuparData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.setuparData == null)
			return super.FAILED;
		
		
		if (recordInfo.setuparData.basicKey   == null ||
			recordInfo.setuparData.basicToken == null	 )	
		
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_SETUPAR_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_SETUPAR_MISSING;
	}
}
