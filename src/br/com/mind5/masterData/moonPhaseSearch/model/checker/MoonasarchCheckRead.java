package br.com.mind5.masterData.moonPhaseSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MoonasarchCheckRead extends ModelCheckerTemplateSimpleV2<MoonasarchInfo> {
	
	public MoonasarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MoonasarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_PHASE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
