package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmplateCheckRead extends ModelCheckerTemplateSimpleV2<EmplateInfo> {

	public EmplateCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplateInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.username		== null	||
			recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_MANDATORY_FIELD_EMPTY;
	}
}
