package br.com.mind5.config.sysStoreBusinessContent.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SytorbcCheckRead extends ModelCheckerTemplateSimple<SytorbcInfo> {

	public SytorbcCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SytorbcInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_STORE_BC_MANDATORY_FIELD_EMPTY;
	}
}
