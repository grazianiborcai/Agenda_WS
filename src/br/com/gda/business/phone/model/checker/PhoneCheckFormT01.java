package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.form.common.Form;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PhoneCheckFormT01 extends ModelCheckerTemplateSimple<PhoneInfo> {

	public PhoneCheckFormT01() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		
		if (Form.T01.getCodForm().equals(recordInfo.codForm))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.FORM_PHONE_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.FORM_PHONE_INVALID;
	}
}
