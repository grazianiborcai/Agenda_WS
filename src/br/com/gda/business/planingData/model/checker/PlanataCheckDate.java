package br.com.gda.business.planingData.model.checker;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PlanataCheckDate extends ModelCheckerTemplateSimple<PlanataInfo> {

	public PlanataCheckDate() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PlanataInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.date == null)			
			return super.FAILED;
		
		
		if (isBeforeNow(recordInfo.date))		
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isBeforeNow(LocalDate date) {
		LocalDate dateNow = DefaultValue.localDateNow();
		return date.isBefore(dateNow);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AGED_DATE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AGED_DATE;
	}
}
