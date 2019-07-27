package br.com.gda.payment.payOrderItemStatus.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;

public final class PaytusemCheckRefresh extends ModelCheckerTemplateSimple<PaytusemInfo> {

	public PaytusemCheckRefresh() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaytusemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    	<= 0	||
			 recordInfo.codPayOrder    	<= 0	||
			// recordInfo.idOrderPartner	== null	||		//TODO: remover ?
			 recordInfo.cusparData  	== null	||
			 recordInfo.codLanguage		== null	||
			 recordInfo.username    	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_STATUS_ITEM_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_STATUS_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
