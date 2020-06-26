package br.com.mind5.business.addressSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class AddresnapCheckHasEmployee extends ModelCheckerTemplateSimpleV2<AddresnapInfo>{

	public AddresnapCheckHasEmployee(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddresnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 ||
			 recordInfo.codEmployee <= 0  )		
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SNAP_EMPLOYEE_IS_EMPTY;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_SNAP_EMPLOYEE_IS_FILLED;
	}
}
