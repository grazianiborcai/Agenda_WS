package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddresnapUser extends ModelCheckerTemplateSimple_<CusparInfo> {

	public CusparCheckAddresnapUser() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CusparInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.addresnapData == null)
			return super.FAILED;
		
		if (recordInfo.addresnapData.codUser == recordInfo.codUser)
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_ADDRESS_DIF_USER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_ADDRESS_DIF_USER;
	}
}
