package br.com.mind5.form.formPhone.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FormoneCheckRead extends ModelCheckerTemplateSimple<FormoneInfo> {

	public FormoneCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FormoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountry == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_PHONE_MANDATORY_FIELD_EMPTY;
	}
}
