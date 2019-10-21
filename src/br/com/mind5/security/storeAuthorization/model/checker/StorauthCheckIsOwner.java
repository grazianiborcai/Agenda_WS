package br.com.mind5.security.storeAuthorization.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.UserCateg;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthCheckIsOwner extends ModelCheckerTemplateSimpleV2<StorauthInfo> {

	public StorauthCheckIsOwner(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorauthInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codUserCategory == UserCateg.OWNER.getCodUserCateg() )			
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
