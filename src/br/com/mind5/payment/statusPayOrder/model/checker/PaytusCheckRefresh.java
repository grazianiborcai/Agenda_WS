package br.com.mind5.payment.statusPayOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckRefresh extends ModelCheckerTemplateSimple_<PaytusInfo> {

	public PaytusCheckRefresh() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaytusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    	<= 0	||
			 recordInfo.codPayOrder    	<= 0	||			 
			 recordInfo.codLanguage		== null	||
			 recordInfo.username    	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_STATUS_HEADER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_STATUS_HEADER_MANDATORY_FIELD_EMPTY;
	}
}
