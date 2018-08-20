package br.com.gda.business.timeRange.model.checker;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import br.com.gda.business.timeRange.info.DateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class DateCheck extends ModelCheckerTemplateSimple<DateInfo> {
	private final boolean OK = true;
	private final boolean BAD_DATE = false;
	
	public DateCheck() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(DateInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.date == null	)
			return BAD_DATE;	
		
		if (isPast(recordInfo))			
			return BAD_DATE;	
		
		return OK;
	}
	
	
	
	private boolean isPast(DateInfo recordInfo) {
		ZonedDateTime nowUtc = ZonedDateTime.now(ZoneOffset.UTC);
		LocalDate dateUtc = nowUtc.toLocalDate();
		
		return dateUtc.isAfter(recordInfo.date);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.BAD_DATE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.BAD_DATE;
	}
}
