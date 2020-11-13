package br.com.mind5.config.sysStoreSignup.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SysotupCheckRead extends ModelCheckerTemplateSimple<SysotupInfo> {

	public SysotupCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SysotupInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_SIGNUP_MANDATORY_FIELD_EMPTY;
	}
}
