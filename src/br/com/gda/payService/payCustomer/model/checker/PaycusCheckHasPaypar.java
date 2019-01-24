package br.com.gda.payService.payCustomer.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusCheckHasPaypar extends ModelCheckerTemplateSimple<PaycusInfo> {
	
	public PaycusCheckHasPaypar(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaycusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codPayPartner <= 0 )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PAY_CUS_PAY_PARTNER_IS_BLANK)
			return SystemMessage.PAY_CUS_PAY_PARTNER_IS_BLANK;
		
		return SystemMessage.PAY_CUS_PAY_PARTNER_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PAY_CUS_PAY_PARTNER_IS_FILLED;	
			
		return SystemCode.PAY_CUS_PAY_PARTNER_IS_BLANK;
	}
}
