package br.com.gda.payment.statusPayOrder.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;

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
