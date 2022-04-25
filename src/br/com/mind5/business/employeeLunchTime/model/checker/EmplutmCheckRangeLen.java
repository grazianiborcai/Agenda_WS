package br.com.mind5.business.employeeLunchTime.model.checker;

import java.sql.Connection;
import java.time.Duration;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public class EmplutmCheckRangeLen extends ModelCheckerTemplateSimple<EmplutmInfo> {
	private final int TEN_MIN = 600;
	
	public EmplutmCheckRangeLen(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplutmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.beginTime == null ||
		     recordInfo.endTime   == null		)
			
			return super.FAILED;

		
		if (computeDuration(recordInfo) < TEN_MIN)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private long computeDuration(EmplutmInfo recordInfo) {
		return Duration.between(recordInfo.beginTime, recordInfo.endTime).getSeconds();
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_RANGE_TOO_SHORT;	
	}
}
