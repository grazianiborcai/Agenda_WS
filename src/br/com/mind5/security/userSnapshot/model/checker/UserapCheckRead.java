package br.com.mind5.security.userSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapCheckRead extends ModelCheckerTemplateSimpleV2<UserapInfo> {

	public UserapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UserapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codSnapshot 	<= 0 	||
			recordInfo.username 	== null	||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
