package br.com.gda.webhook.moipRefund.model.checker;

import java.sql.Connection;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipCheckInsert extends ModelCheckerTemplateSimple<WokefumoipInfo> {

	public WokefumoipCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(WokefumoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.title == null)		
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.WHOOK_MOIP_PAY_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.WHOOK_MOIP_PAY_MANDATORY_FIELD_EMPTY;
	}
}
