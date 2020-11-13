package br.com.mind5.security.userList.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisCheckHasPerson extends ModelCheckerTemplateSimple<UselisInfo> {

	public UselisCheckHasPerson(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(UselisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  <= 0 ||
			 recordInfo.codPerson <= 0		)		
			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_LIST_MANDATORY_FIELD_EMPTY;
	}
}
