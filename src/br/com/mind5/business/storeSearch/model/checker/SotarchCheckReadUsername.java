package br.com.mind5.business.storeSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SotarchCheckReadUsername extends ModelCheckerTemplateSimpleV2<SotarchInfo> {

	public SotarchCheckReadUsername(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SotarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
