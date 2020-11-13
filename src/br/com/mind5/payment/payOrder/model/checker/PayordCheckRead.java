package br.com.mind5.payment.payOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckRead extends ModelCheckerTemplateSimple<PayordInfo> {

	public PayordCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codPayOrder <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username    == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
