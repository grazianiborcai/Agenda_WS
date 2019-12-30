package br.com.mind5.business.customerList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CuslisCheckRead extends ModelCheckerTemplateSimpleV2<CuslisInfo> {

	public CuslisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CuslisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_LIST_MANDATORY_FIELD_EMPTY;
	}
}
