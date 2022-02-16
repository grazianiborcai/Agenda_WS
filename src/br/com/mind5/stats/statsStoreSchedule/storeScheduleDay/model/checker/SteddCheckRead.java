package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;

public final class SteddCheckRead extends ModelCheckerTemplateSimple<SteddInfo> {

	public SteddCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SteddInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.date 		== null	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_DAY_MANDATORY_FIELD_EMPTY;
	}
}
