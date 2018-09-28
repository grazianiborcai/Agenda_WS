package br.com.gda.business.planningTime.model.checker;

import java.sql.Connection;
import java.time.LocalDate;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PlanCheckDate extends ModelCheckerTemplateSimple<PlanInfo> {

	public PlanCheckDate() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PlanInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.datas == null || recordInfo.datas.isEmpty())			
			return FAILED;
		
		LocalDate dateNow = DefaultValue.dateNow();
		
		
		for (PlanDataInfo eachData: recordInfo.datas) {
			if ( eachData.date.isBefore(dateNow) )				
				return FAILED;
		}
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AGED_DATE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AGED_DATE;
	}
}
