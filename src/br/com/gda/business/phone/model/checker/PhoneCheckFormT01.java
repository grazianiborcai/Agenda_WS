package br.com.gda.business.phone.model.checker;

import java.sql.Connection;

import br.com.gda.business.form.common.Form;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class PhoneCheckFormT01 extends ModelCheckerTemplateSimpleV2<PhoneInfo> {

	public PhoneCheckFormT01(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PhoneInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codForm == null)
			return super.FAILED;
		
		
		if (Form.T01.getCodForm().equals(recordInfo.codForm))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_FORM_OK;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_FORM_INVALID;
	}
}
