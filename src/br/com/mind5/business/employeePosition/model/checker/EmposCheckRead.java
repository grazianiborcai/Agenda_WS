package br.com.mind5.business.employeePosition.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmposCheckRead extends ModelCheckerTemplateSimple_<EmposInfo> {

	public EmposCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmposInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 )			
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
