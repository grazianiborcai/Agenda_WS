package br.com.mind5.business.employeeWorkTimeRange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmpworgCheckRead extends ModelCheckerTemplateSimpleV2<EmpworgInfo> {

	public EmpworgCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpworgInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.codWeekday 	<= 0 	||
			recordInfo.beginTime 	== null ||
			recordInfo.endTime 		== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_RANGE_MANDATORY_FIELD_EMPTY;
	}
}
