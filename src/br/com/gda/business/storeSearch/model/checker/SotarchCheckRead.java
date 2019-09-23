package br.com.gda.business.storeSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeSearch.info.SotarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class SotarchCheckRead extends ModelCheckerTemplateSimpleV2<SotarchInfo> {

	public SotarchCheckRead(ModelCheckerOption option) {
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
