package br.com.gda.business.address.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.info.Form;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class AddressCheckFormA01 extends ModelCheckerTemplateSimple<AddressInfo> {

	public AddressCheckFormA01() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		
		if (Form.A01.getCodForm().equals(recordInfo.codForm))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ADDRESS_FORM_INVALID;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ADDRESS_FORM_INVALID;
	}
}
