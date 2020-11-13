package br.com.mind5.business.address.model.checker;

import java.sql.Connection;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AddressCheckFlagDel extends ModelCheckerTemplateSimple<AddressInfo> {

	public AddressCheckFlagDel(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isDeleted )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_FLAG_DELETE_TRUE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_FLAG_DELETE_FALSE;
	}
}
