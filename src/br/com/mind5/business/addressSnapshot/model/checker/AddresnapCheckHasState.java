package br.com.mind5.business.addressSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AddresnapCheckHasState extends ModelCheckerTemplateSimple<AddresnapInfo> {

	public AddresnapCheckHasState(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddresnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codState == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_SNAP_HAS_STATE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SNAP_HAS_NO_STATE;
	}
}
