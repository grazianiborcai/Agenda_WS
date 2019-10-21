package br.com.mind5.business.planingData.model.checker;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class PlanataCheckDate extends ModelCheckerTemplateSimple_<PlanataInfo> {

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
