package br.com.gda.business.employee.model.checker;

import java.sql.Connection;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmpCheckHasUser extends ModelCheckerTemplateSimple<EmpInfo> {
	
	public EmpCheckHasUser(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.userData == null)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.USER_IS_NULL)
			return SystemMessage.USER_IS_NULL;
		
		return SystemMessage.USER_IS_FILLED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.USER_IS_FILLED;	
			
		return SystemCode.USER_IS_NULL;
	}
}
