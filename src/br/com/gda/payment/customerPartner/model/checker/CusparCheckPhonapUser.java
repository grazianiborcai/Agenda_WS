package br.com.gda.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPhonapUser extends ModelCheckerTemplateSimple_<CusparInfo> {

	public CusparCheckPhonapUser() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phonapData == null)
			return super.FAILED;
		
		if (recordInfo.phonapData.codUser == recordInfo.codUser)
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_PHONE_DIF_USER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_PHONE_DIF_USER;
	}
}
