package br.com.mind5.business.calendarCatalogueData.model.checker;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CalguataCheckYearMonth extends ModelCheckerTemplateSimple<CalguataInfo> {

	public CalguataCheckYearMonth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalguataInfo recordInfo, Connection conn, String schemaName) {	
		if (isAged(recordInfo))			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isAged(CalguataInfo recordInfo) {
		LocalDate now = DefaultValue.localDateNow();
		
		if (recordInfo.year < now.getYear())
			return true;
		
		if (recordInfo.month < now.getMonthValue())
			return true;
		
		return false;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_CATALOGUE_DATA_AGED_DATE;
	}
}
