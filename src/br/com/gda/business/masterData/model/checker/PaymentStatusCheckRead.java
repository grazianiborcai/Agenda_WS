package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PaymentStatusCheckRead extends ModelCheckerTemplateSimple_<PaymentStatusInfo> {
	
	public PaymentStatusCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaymentStatusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAYMENT_STATUS_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAYMENT_STATUS_MANDATORY_FIELD_EMPTY;
	}
}
