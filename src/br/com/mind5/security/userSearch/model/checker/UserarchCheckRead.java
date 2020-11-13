package br.com.mind5.security.userSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UserarchCheckRead extends ModelCheckerTemplateSimple<UserarchInfo> {

	public UserarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UserarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)		
			
			return super.FAILED;		
		
		
		if (recordInfo.codUser 			<= 0 	&&
			recordInfo.codPerson 		<= 0 	&&
			recordInfo.codUserCategory 	<= 0 	&&
			recordInfo.username			== 		null	)		
			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
