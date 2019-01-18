package br.com.gda.payService.payPartnerStore.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;

public final class PayparStoreCheckRead extends ModelCheckerTemplateSimple<PayparStoreInfo> {

	public PayparStoreCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayparStoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner <= 0	||
			   recordInfo.codStore <= 0 	)			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
