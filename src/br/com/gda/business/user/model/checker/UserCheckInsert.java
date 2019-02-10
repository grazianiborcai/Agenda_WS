package br.com.gda.business.user.model.checker;

import java.sql.Connection;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class UserCheckInsert extends ModelCheckerTemplateSimple<UserInfo> {

	public UserCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(UserInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    	<= 0 						||
			 recordInfo.codLanguage 	== null						||
			 recordInfo.personData 		== null						||
			 recordInfo.codUserCategory	== DefaultValue.character()		)
			return FAILED;
		
		
		if ( recordInfo.personData.email == null )
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
