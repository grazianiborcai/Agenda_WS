package br.com.gda.security.storeAuthorization.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.UserCateg;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;

public final class StorauthCheckIsCategOwner extends ModelCheckerTemplateSimple<StorauthInfo> {

	public StorauthCheckIsCategOwner() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StorauthInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codUserCategory == UserCateg.OWNER.getCodUserCateg() )			
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
