package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckIsFee extends ModelCheckerTemplateSimple_<PayordemInfo> {

	public PayordemCheckIsFee(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codFeeCateg == DefaultValue.character())			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.PAY_ORDER_ITEM_IS_FEE)
			return SystemMessage.PAY_ORDER_ITEM_IS_FEE;
		
		return SystemMessage.PAY_ORDER_ITEM_IS_NOT_FEE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PAY_ORDER_ITEM_IS_FEE;	
		
		return SystemCode.PAY_ORDER_ITEM_IS_NOT_FEE;
	}
}
