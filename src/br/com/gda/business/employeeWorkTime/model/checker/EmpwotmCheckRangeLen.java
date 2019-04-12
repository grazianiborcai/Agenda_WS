package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.time.Duration;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public class EmpwotmCheckRangeLen extends ModelCheckerTemplateSimple<EmpwotmInfo> {
	private final int ONE_HOUR = 3600;
	
	public EmpwotmCheckRangeLen() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.beginTime == null ||
		   recordInfo.endTime  == null		)
			return super.FAILED;
			
		long duration = computeDuration(recordInfo);
		
		if (duration < ONE_HOUR)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private long computeDuration(EmpwotmInfo recordInfo) {
		return Duration.between(recordInfo.beginTime, recordInfo.endTime).getSeconds();
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.EMP_WTIME_RANGE_TOO_SHORT;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMP_WTIME_RANGE_TOO_SHORT;	
	}
}
