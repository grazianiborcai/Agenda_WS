package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class AreaPhoneCheckRead extends ModelCheckerTemplateSimple_<AreaPhoneInfo> {
	
	public AreaPhoneCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AreaPhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AREA_PHONE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AREA_PHONE_MANDATORY_FIELD_EMPTY;
	}
}
