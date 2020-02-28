package br.com.mind5.payment.refundOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckRefund extends ModelCheckerTemplateSimpleV2<RefemInfo> {

	public RefemCheckRefund(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codPayOrder		<= 0 	||
			 recordInfo.codPayOrderItem	<= 0 	||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
