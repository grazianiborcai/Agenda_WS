package br.com.mind5.webhook.moipMultipayment.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipCheckInsert extends ModelCheckerTemplateSimpleV2<WokaymoipInfo> {

	public WokaymoipCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(WokaymoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.id == null)		
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.WHOOK_MOIP_PAY_MANDATORY_FIELD_EMPTY;
	}
}
