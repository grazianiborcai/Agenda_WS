package br.com.mind5.business.timeRange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.timeRange.info.TimeRangeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class TimeRangeCheckRange extends ModelCheckerTemplateSimple_<TimeRangeInfo> {
	private final boolean OK = true;
	private final boolean BAD_RANGE = false;
	
	public TimeRangeCheckRange() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(TimeRangeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.beginTime == null || recordInfo.endTime == null	)
			return BAD_RANGE;	
		
		if (recordInfo.beginTime.isAfter(recordInfo.endTime))			
			return BAD_RANGE;	
		
		if (recordInfo.beginTime.equals(recordInfo.endTime))			
			return BAD_RANGE;	
		
		return OK;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.BAD_TIME_RANGE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.BAD_TIME_RANGE;
	}
}
