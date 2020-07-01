package br.com.mind5.business.storeNearby.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StorbyCheckRead extends ModelCheckerTemplateSimpleV2<StorbyInfo> {

	public StorbyCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorbyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codAddress 	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_MANDATORY_FIELD_EMPTY;
	}
}
