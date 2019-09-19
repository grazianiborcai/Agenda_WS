package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PayparCheckRead extends ModelCheckerTemplateSimple_<PayparInfo> {
	
	public PayparCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayparInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPayPartner <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_PARTNER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_PARTNER_MANDATORY_FIELD_EMPTY;
	}
}
