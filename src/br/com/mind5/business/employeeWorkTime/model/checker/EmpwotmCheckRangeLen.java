package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.time.Duration;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public class EmpwotmCheckRangeLen extends ModelCheckerTemplateSimpleV2<EmpwotmInfo> {
	private final int ONE_HOUR = 3600;
	
	public EmpwotmCheckRangeLen(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.beginTime == null ||
		     recordInfo.endTime  == null		)
			
			return super.FAILED;

		
		if (computeDuration(recordInfo) < ONE_HOUR)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private long computeDuration(EmpwotmInfo recordInfo) {
		return Duration.between(recordInfo.beginTime, recordInfo.endTime).getSeconds();
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_RANGE_TOO_SHORT;	
	}
}
