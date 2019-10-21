package br.com.mind5.business.timeRange.model.checker;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import br.com.mind5.business.timeRange.info.DateInfo_;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class DateCheck_ extends ModelCheckerTemplateSimple_<DateInfo_> {
	private final boolean OK = true;
	private final boolean BAD_DATE = false;
	
	public DateCheck_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(DateInfo_ recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.date == null	)
			return BAD_DATE;	
		
		if (isPast(recordInfo))			
			return BAD_DATE;	
		
		return OK;
	}
	
	
	
	private boolean isPast(DateInfo_ recordInfo) {
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
