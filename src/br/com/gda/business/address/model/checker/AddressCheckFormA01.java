package br.com.gda.business.address.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.common.Form;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class AddressCheckFormA01 extends ModelCheckerTemplateSimpleV2<AddressInfo> {

	public AddressCheckFormA01(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codForm == null)			
			return super.FAILED;
		
		
		if (Form.A01.getCodForm().equals(recordInfo.codForm))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_ADDRESS_OK;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_ADDRESS_INVALID;
	}
}
