package br.com.mind5.webhook.moipRefund.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipCheckInsert extends ModelCheckerTemplateSimple<WokefumoipInfo> {

	public WokefumoipCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(WokefumoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.title == null )		
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.WHOOK_MOIP_REFUND_MANDATORY_FIELD_EMPTY;
	}
}
