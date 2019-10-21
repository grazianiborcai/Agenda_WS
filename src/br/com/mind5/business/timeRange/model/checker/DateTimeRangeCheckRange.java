package br.com.mind5.business.timeRange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.timeRange.info.DateTimeRangeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class DateTimeRangeCheckRange extends ModelCheckerTemplateSimple_<DateTimeRangeInfo> {
	private final boolean OK = true;
	private final boolean BAD_RANGE = false;
	
	public DateTimeRangeCheckRange() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(DateTimeRangeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.dateValidFrom == null || recordInfo.dateValidTo == null ||
			recordInfo.timeValidFrom == null || recordInfo.timeValidTo == null	)
			return BAD_RANGE;	
		
		if (recordInfo.dateValidFrom.isAfter(recordInfo.dateValidTo))			
			return BAD_RANGE;		
		
		if (recordInfo.dateValidFrom.isEqual(recordInfo.dateValidTo) &&
			recordInfo.timeValidFrom.isAfter(recordInfo.timeValidTo))			
			return BAD_RANGE;	
		
		if (recordInfo.dateValidFrom.isEqual(recordInfo.dateValidTo) &&
			recordInfo.timeValidFrom.equals(recordInfo.timeValidTo))			
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
