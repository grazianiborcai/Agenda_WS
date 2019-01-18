package br.com.gda.payService.payPartnerOwner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;

public final class PayparOwnerCheckHasCountry extends ModelCheckerTemplateSimple<PayparOwnerInfo> {
	
	public PayparOwnerCheckHasCountry(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayparOwnerInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codCountry == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PAY_PARTNER_OWNER_IS_NULL)
			return SystemMessage.PAY_PARTNER_OWNER_IS_NULL;
		
		return SystemMessage.PAY_PARTNER_OWNER_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PAY_PARTNER_OWNER_IS_FILLED;	
			
		return SystemCode.PAY_PARTNER_OWNER_IS_NULL;
	}
}
