package br.com.mind5.business.storeTextSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextarchCheckRead extends ModelCheckerTemplateSimple<StorextarchInfo> {

	public StorextarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0	||
			recordInfo.codStore <= 0	||
			recordInfo.username	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
