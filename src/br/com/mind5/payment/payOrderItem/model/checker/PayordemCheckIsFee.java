package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.feeCategory.info.Feecat;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckIsFee extends ModelCheckerTemplateSimple<PayordemInfo> {

	public PayordemCheckIsFee(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codFeeCateg == DefaultValue.character())			
			return super.FAILED;
		
		if (recordInfo.codFeeCateg == Feecat.SERVICE.getCodCateg())			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_IS_FEE;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_ITEM_IS_NOT_FEE;
	}
}
