package br.com.gda.payment.ownerPartner.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckHasCountry extends ModelCheckerTemplateSimple<OwnparInfo> {
	
	public OwnparCheckHasCountry(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnparInfo recordInfo, Connection conn, String schemaName) {	
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
