package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmpwotmCheckRead extends ModelCheckerTemplateSimple<EmpwotmInfo> {

	public EmpwotmCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.codWeekday 	<= 0 	||
			recordInfo.codLanguage	== null	||
			recordInfo.username		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_MANDATORY_FIELD_EMPTY;
	}
}
