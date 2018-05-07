package br.com.gda.business.position.model.checker;

import java.sql.Connection;

import br.com.gda.business.position.info.PositionInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerPositionMandatoryRead extends ModelCheckerTemplate<PositionInfo> {

	public CheckerPositionMandatoryRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PositionInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return RESULT_FAILED;
		
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
