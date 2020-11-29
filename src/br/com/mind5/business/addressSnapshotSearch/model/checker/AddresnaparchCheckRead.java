package br.com.mind5.business.addressSnapshotSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class AddresnaparchCheckRead extends ModelCheckerTemplateSimple<AddresnaparchInfo> {

	public AddresnaparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddresnaparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		
		if ( recordInfo.codUser 		<= 0 &&
			 recordInfo.codUserSnapshot <= 0 &&
			 recordInfo.codSnapshot 	<= 0	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SNAP_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
