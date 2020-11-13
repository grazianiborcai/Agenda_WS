package br.com.mind5.config.sysOwnerConfig.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SysonfigCheckRead extends ModelCheckerTemplateSimple<SysonfigInfo> {

	public SysonfigCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SysonfigInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_OWNER_MANDATORY_FIELD_EMPTY;
	}
}
