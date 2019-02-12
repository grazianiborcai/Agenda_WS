package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.RolurInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class RolurCheckRead extends ModelCheckerTemplateSimple<RolurInfo> {

	public RolurCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RolurInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codRole == null 	&&
			recordInfo.codUri  == null		)			
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
