package br.com.mind5.business.customerList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CuslisCheckRead extends ModelCheckerTemplateSimple<CuslisInfo> {

	public CuslisCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CuslisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codCustomer 	<= 0 	||	
			recordInfo.username 	== null	||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUS_LIST_MANDATORY_FIELD_EMPTY;
	}
}
