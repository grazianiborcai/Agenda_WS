package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class EmplevateCheckWrite extends ModelCheckerTemplateSimple_<EmplevateInfo> {

	public EmplevateCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmplevateInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 	
			|| recordInfo.codStore 			<= 0
			|| recordInfo.codEmployee		<= 0
			|| recordInfo.dateValidFrom		== null
			|| recordInfo.dateValidTo		== null
			|| recordInfo.timeValidFrom		== null
			|| recordInfo.timeValidTo		== null
			|| recordInfo.username			== null
			|| recordInfo.codLanguage		== null	)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
