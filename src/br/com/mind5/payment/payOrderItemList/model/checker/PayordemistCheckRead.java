package br.com.mind5.payment.payOrderItemList.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class PayordemistCheckRead extends ModelCheckerTemplateSimpleV2<PayordemistInfo> {

	public PayordemistCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordemistInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codPayOrder		<= 0 	||
			 recordInfo.codPayOrderItem	<= 0	||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_LIST_MANDATORY_FIELD_EMPTY;
	}
}
