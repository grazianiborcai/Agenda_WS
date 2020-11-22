package br.com.mind5.business.employeeSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmparchCheckReadSytotauh extends ModelCheckerTemplateSimple<EmparchInfo> {

	public EmparchCheckReadSytotauh(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmparchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
