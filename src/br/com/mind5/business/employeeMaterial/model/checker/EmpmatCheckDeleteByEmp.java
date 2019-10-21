package br.com.mind5.business.employeeMaterial.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpmatCheckDeleteByEmp extends ModelCheckerTemplateSimple_<EmpmatInfo> {

	public EmpmatCheckDeleteByEmp() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 
			|| recordInfo.codEmployee	<= 0 
			|| recordInfo.username		== null
			|| recordInfo.codLanguage	== null )
			
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
