package br.com.mind5.webhook.moipRefund.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipCheckInsert extends ModelCheckerTemplateSimple_<WokefumoipInfo> {

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
