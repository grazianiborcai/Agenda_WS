package br.com.mind5.business.address.model.checker;

import java.sql.Connection;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AddressCheckIsDefault extends ModelCheckerTemplateSimple<AddressInfo> {

	public AddressCheckIsDefault(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {			
		return recordInfo.isDefault;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_NOT_DEFAULT;
	}
}
