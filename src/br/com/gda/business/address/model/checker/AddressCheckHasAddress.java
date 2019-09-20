package br.com.gda.business.address.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class AddressCheckHasAddress extends ModelCheckerTemplateSimpleV2<AddressInfo> {

	public AddressCheckHasAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codAddress > 0 )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_IS_FILLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_IS_NULL;
	}
}
