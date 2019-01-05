package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckWritePhone extends ModelCheckerTemplateSimple<PayCusInfo> {

	public PayCusCheckWritePhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayCusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPhoneRef <= 0)
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	//TODO: Criar mensagem indicando campo Ref
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_COD_IS_BLANK;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_COD_IS_BLANK;
	}
}
