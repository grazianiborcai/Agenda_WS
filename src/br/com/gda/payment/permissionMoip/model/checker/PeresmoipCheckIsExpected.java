package br.com.gda.payment.permissionMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipCheckIsExpected extends ModelCheckerTemplateSimple<PeresmoipInfo> {

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
