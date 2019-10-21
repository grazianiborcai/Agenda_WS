package br.com.mind5.business.customer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CusCheckHasPhone extends ModelCheckerTemplateSimple_<CusInfo> {
	
	public CusCheckHasPhone(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null || recordInfo.phones.isEmpty())			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.PHONE_IS_NULL)
			return SystemMessage.PHONE_IS_NULL;
		
		return SystemMessage.PHONE_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PHONE_IS_FILLED;	
			
		return SystemCode.PHONE_IS_NULL;
	}
}
