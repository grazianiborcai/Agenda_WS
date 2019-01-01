package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckWritePhone extends ModelCheckerTemplateSimple<PayCusInfo> {

	public PayCusCheckWritePhone() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayCusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)
			return SUCCESS;
		
		
		if (recordInfo.phones.isEmpty())
			return SUCCESS;
		
		
		for (PhoneInfo eachPhone : recordInfo.phones) {
			if (checkPhone(eachPhone) == FAILED)
				return FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	private boolean checkPhone(PhoneInfo phone) {
		if (phone.codPhone <= 0)
			return SUCCESS;
		
		return FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PHONE_COD_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PHONE_COD_IS_FILLED;
	}
}
