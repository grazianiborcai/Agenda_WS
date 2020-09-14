package br.com.mind5.business.storeFavorite.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StoriteCheckReadAuth extends ModelCheckerTemplateSimpleV2<StoriteInfo> {

	public StoriteCheckReadAuth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoriteInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.username 	== null	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_FAVORITE_MANDATORY_FIELD_EMPTY;
	}
}
