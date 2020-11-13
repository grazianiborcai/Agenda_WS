package br.com.mind5.masterData.businessAreaSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BusarearchCheckRead extends ModelCheckerTemplateSimple<BusarearchInfo> {
	
	public BusarearchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BusarearchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BUSINESS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
