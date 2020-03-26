package br.com.mind5.business.employeePositionSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmposarchCheckRead extends ModelCheckerTemplateSimple<EmposarchInfo> {

	public EmposarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmposarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;
		
		
		if (recordInfo.codStore 	<= 0 	&&
			recordInfo.codEmployee 	<= 0		)			
			
			return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
