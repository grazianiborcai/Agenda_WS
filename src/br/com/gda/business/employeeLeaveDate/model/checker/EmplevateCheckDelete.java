package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class EmplevateCheckDelete extends ModelCheckerTemplateSimple_<EmplevateInfo> {
	
	public EmplevateCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmplevateInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	 <= 0 
			 || recordInfo.codStore  	 <= 0 
			 || recordInfo.codEmployee 	 <= 0 
			 || recordInfo.dateValidFrom == null
			 || recordInfo.timeValidFrom == null		
			 || recordInfo.codLanguage	 == null 
			 ||	recordInfo.username		 == null		)
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
