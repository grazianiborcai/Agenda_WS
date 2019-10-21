package br.com.mind5.payment.partnerMoip.permissionMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckIsExpected extends ModelCheckerTemplateSimple_<PeresmoipInfo> {

	public PeresmoipCheckIsExpected() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PeresmoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.isExpected)			
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MOIP_PERM_RESP_IS_NOT_EXPECTED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MOIP_PERM_RESP_IS_NOT_EXPECTED;
	}
}
