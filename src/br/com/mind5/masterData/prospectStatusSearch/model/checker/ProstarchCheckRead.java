package br.com.mind5.masterData.prospectStatusSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class ProstarchCheckRead extends ModelCheckerTemplateSimple<ProstarchInfo> {

	public ProstarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(ProstarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PROSP_STATUS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
