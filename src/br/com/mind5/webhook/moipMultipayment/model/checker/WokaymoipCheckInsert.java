package br.com.mind5.webhook.moipMultipayment.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipCheckInsert extends ModelCheckerTemplateSimple_<WokaymoipInfo> {

	public WokaymoipCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(WokaymoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.id == null)		
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
