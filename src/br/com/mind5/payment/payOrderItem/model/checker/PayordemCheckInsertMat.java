package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckInsertMat extends ModelCheckerTemplateSimpleV2<PayordemInfo> {

	public PayordemCheckInsertMat(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner	<= 0	||
			recordInfo.codStore	<= 0	||
			recordInfo.codMat	<= 0		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
