package br.com.mind5.payment.payOrderSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchCheckReadWebhook extends ModelCheckerTemplateSimple<PayordarchInfo> {

	public PayordarchCheckReadWebhook(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
