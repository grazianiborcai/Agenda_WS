package br.com.mind5.business.form.formAddress.model.checker;

import java.sql.Connection;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class FormAddressCheckRead extends ModelCheckerTemplateSimple_<FormAddressInfo> {

	public FormAddressCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FormAddressInfo recordInfo, Connection conn, String schemaName) {	
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
