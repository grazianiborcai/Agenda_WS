package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmpLDateCheckKey extends ModelCheckerTemplateSimple<EmpLDateInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public EmpLDateCheckKey() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpLDateInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	 <= 0 
			 || recordInfo.codStore  	 <= 0 
			 || recordInfo.codEmployee 	 <= 0 
			 || recordInfo.dateValidFrom == null
			 || recordInfo.timeValidFrom == null	)			
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
