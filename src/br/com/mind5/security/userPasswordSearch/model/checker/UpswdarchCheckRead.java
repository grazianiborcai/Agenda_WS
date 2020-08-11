package br.com.mind5.security.userPasswordSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class UpswdarchCheckRead extends ModelCheckerTemplateSimpleV2<UpswdarchInfo> {

	public UpswdarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UpswdarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	|| 	
			 recordInfo.username 	== null	||
			 recordInfo.codLanguage == null	||
			 recordInfo.lastChanged == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
