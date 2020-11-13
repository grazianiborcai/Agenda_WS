package br.com.mind5.business.storeTextDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextaultCheckRead extends ModelCheckerTemplateSimple<StorextaultInfo> {

	public StorextaultCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextaultInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0	||
			recordInfo.codStore <= 0	||
			recordInfo.username	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_DEFAULT_MANDATORY_FIELD_EMPTY;
	}
}
