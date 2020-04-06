package br.com.mind5.masterData.moonPhase.model.checker;

import java.sql.Connection;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MoonaseCheckRead extends ModelCheckerTemplateSimpleV2<MoonaseInfo> {
	
	public MoonaseCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MoonaseInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codMoonPhase	<= 0 	||
			 recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_PHASE_MANDATORY_FIELD_EMPTY;
	}
}
