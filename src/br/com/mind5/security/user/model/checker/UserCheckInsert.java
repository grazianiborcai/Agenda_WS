package br.com.mind5.security.user.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckInsert extends ModelCheckerTemplateSimple_<UserInfo> {

	public UserCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    	<= 0 						||
			 recordInfo.codLanguage 	== null						||
			 recordInfo.personData 		== null						||
			 recordInfo.codAuthGroup 	== null						||
			 recordInfo.codUserCategory	== DefaultValue.character()		)
			return super.FAILED;
		
		
		if ( recordInfo.personData.email == null )
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.USER_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.USER_MANDATORY_FIELD_EMPTY;
	}
}
