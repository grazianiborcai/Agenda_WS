package br.com.gda.employee.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerEmpCodEmployee extends ModelCheckerTemplate<EmpInfo> {
	private final boolean FIELD_NOT_NULL = true;
	private final boolean EMPTY_FIELD = false;
	
	public CheckerEmpCodEmployee(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codEmployee >= 0 )			
			return FIELD_NOT_NULL;
		
		
		return EMPTY_FIELD;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.COD_EMPLOYEE_FIELD_NOT_NULL)
			return SystemMessage.COD_EMPLOYEE_FIELD_NOT_NULL;
		
		return SystemMessage.COD_EMPLOYEE_FIELD_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == FIELD_NOT_NULL)
			return SystemCode.COD_EMPLOYEE_FIELD_NOT_NULL;				
		
		return SystemCode.COD_EMPLOYEE_FIELD_IS_EMPTY;
	}
}
