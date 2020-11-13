package br.com.mind5.form.formAddress.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FormessCheckRead extends ModelCheckerTemplateSimple<FormessInfo> {

	public FormessCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FormessInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountry == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_ADDRESS_MANDATORY_FIELD_EMPTY;
	}
}
