package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class TimezoneCheckRead extends ModelCheckerTemplateSimple<TimezoneInfo> {

	public TimezoneCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(TimezoneInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
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
