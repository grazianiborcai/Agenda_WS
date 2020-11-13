package br.com.mind5.business.storeFavorite.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoriteCheckRead extends ModelCheckerTemplateSimple<StoriteInfo> {

	public StoriteCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoriteInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.codUser 	<= 0	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FAVORITE_MANDATORY_FIELD_EMPTY;
	}
}
