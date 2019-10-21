package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public class EmpwotmCheckRange extends ModelCheckerTemplateSimple_<EmpwotmInfo> {
	
	public EmpwotmCheckRange() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.beginTime == null ||
		   recordInfo.endTime  == null		)
			return super.FAILED;
			
		
		if (recordInfo.beginTime.isAfter(recordInfo.endTime))
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.EMP_WTIME_INVALID_RANGE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMP_WTIME_INVALID_RANGE;	
	}
}
