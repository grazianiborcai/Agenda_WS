package br.com.mind5.business.storeFavoriteSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoritarchCheckRead extends ModelCheckerTemplateSimpleV2<StoritarchInfo> {

	public StoritarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoritarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codStore 	<= 0 &&
			 recordInfo.codUser 	<= 0	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FAVORITE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
