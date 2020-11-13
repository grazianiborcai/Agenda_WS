package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckHasOrderem extends ModelCheckerTemplateSimple<PayordemInfo> {

	public PayordemCheckHasOrderem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOrder 	<= 0 ||
			recordInfo.codOrderItem <= 0	)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
