package br.com.gda.business.employeeMaterial.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class EmpmatCheckWrite extends ModelCheckerTemplateSimple_<EmpmatInfo> {

	public EmpmatCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 
			|| recordInfo.codEmployee	<= 0  	
			|| recordInfo.codMat		<= 0
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
