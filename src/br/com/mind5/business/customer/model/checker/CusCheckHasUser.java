package br.com.mind5.business.customer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class CusCheckHasUser extends ModelCheckerTemplateSimple_<CusInfo> {
	
	public CusCheckHasUser(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codUser <= 0)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CUS_DONT_HAS_USER)
			return SystemMessage.CUS_DONT_HAS_USER;
		
		return SystemMessage.CUS_HAS_USER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.CUS_HAS_USER;	
			
		return SystemCode.CUS_DONT_HAS_USER;
	}
}
