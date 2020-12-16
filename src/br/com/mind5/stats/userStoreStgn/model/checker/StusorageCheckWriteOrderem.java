package br.com.mind5.stats.userStoreStgn.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;

public final class StusorageCheckWriteOrderem extends ModelCheckerTemplateSimple<StusorageInfo> {

	public StusorageCheckWriteOrderem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StusorageInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.codOrder 	<= 0 	|| 	
			recordInfo.codOrderItem <= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_USER_STGN_MANDATORY_FIELD_EMPTY;
	}
}
