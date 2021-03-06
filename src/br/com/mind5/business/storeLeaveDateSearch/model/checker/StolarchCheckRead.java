package br.com.mind5.business.storeLeaveDateSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StolarchCheckRead extends ModelCheckerTemplateSimple<StolarchInfo> {

	public StolarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StolarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.STORE_LDATE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
