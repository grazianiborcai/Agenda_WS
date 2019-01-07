package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusCheckHasAddress extends ModelCheckerTemplateSimple<PayCusInfo> {
	
	public PayCusCheckHasAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayCusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.address == null )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.ADDRESS_IS_NULL)
			return SystemMessage.ADDRESS_IS_NULL;
		
		return SystemMessage.ADDRESS_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.ADDRESS_IS_FILLED;	
			
		return SystemCode.ADDRESS_IS_NULL;
	}
}
