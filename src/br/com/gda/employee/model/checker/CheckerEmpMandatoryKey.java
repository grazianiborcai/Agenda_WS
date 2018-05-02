package br.com.gda.employee.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerEmpMandatoryKey extends ModelCheckerTemplate<EmpInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public CheckerEmpMandatoryKey(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	>= 0 
			 && recordInfo.codEmployee  >= 0 )			
			return KEY_NOT_NULL;		
		
		return EMPTY_KEY;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_KEY_FIELD_NOT_NULL)
			return SystemMessage.EMPLOYEE_KEY_FIELD_NOT_NULL;
		
		return SystemMessage.EMPLOYEE_KEY_FIELD_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == KEY_NOT_NULL)
			return SystemCode.EMPLOYEE_KEY_FIELD_NOT_NULL;				
		
		return SystemCode.EMPLOYEE_KEY_FIELD_IS_EMPTY;
	}
}
