package br.com.gda.business.form.formPhone.model.checker;

import java.sql.Connection;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class FormPhoneCheckRead extends ModelCheckerTemplateSimple_<FormPhoneInfo> {

	public FormPhoneCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FormPhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codCountry == null )			
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
