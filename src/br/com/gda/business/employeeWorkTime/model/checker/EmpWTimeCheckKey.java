package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public class EmpWTimeCheckKey extends ModelCheckerTemplate<EmpWTimeInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public EmpWTimeCheckKey() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	<= 0 
			 || recordInfo.codStore  	<= 0 
			 || recordInfo.codEmployee 	<= 0 
			 || recordInfo.codWeekday	<= 0)			
			return EMPTY_KEY;		
		
		return KEY_NOT_NULL;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		if (makeFailureCodeHook(checkerResult) == SystemCode.KEY_FIELD_NOT_NULL)
			return SystemMessage.KEY_FIELD_NOT_NULL;
		
		return SystemMessage.KEY_FIELD_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == KEY_NOT_NULL)
			return SystemCode.KEY_FIELD_NOT_NULL;				
		
		return SystemCode.KEY_FIELD_IS_EMPTY;
	}
}
