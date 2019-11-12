package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmpwocoCheckRead extends ModelCheckerTemplateSimpleV2<EmpwocoInfo> {

	public EmpwocoCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpwocoInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee  <= 0 	||
			recordInfo.codWeekday	<= 0 	||
			recordInfo.codLanguage	== null ||
			recordInfo.username		== null ||
			recordInfo.beginTime	== null ||
			recordInfo.endTime		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_CONFLICT_MANDATORY_FIELD_EMPTY;
	}
}
