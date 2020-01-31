package br.com.mind5.business.employeeList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmplisCheckSearch extends ModelCheckerTemplateSimpleV2<EmplisInfo> {

	public EmplisCheckSearch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplisInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.persoresData	== null	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username		== null		)					
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LIST_MANDATORY_FIELD_EMPTY;
	}
}
