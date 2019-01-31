package br.com.gda.business.employeePosition.model.checker;

import java.sql.Connection;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class EmposCheckRead extends ModelCheckerTemplateSimple<EmposInfo> {

	public EmposCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmposInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 )			
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
