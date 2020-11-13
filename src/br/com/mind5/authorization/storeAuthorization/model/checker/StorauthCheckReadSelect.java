package br.com.mind5.authorization.storeAuthorization.model.checker;

import java.sql.Connection;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorauthCheckReadSelect extends ModelCheckerTemplateSimple<StorauthInfo> {

	public StorauthCheckReadSelect(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorauthInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||		
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		 )			
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
