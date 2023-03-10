package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckInsert extends ModelCheckerTemplateSimple<PayordemInfo> {

	public PayordemCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayordemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||	
			 recordInfo.codPayOrder		<= 0 	||
			 recordInfo.codPayOrderItem	<= 0 	||
			 recordInfo.codPayPartner	<= 0 	||
			 recordInfo.quantity		<= 0 	||
			 recordInfo.price			<= 0 	||
			 recordInfo.totitem			<= 0 	||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
