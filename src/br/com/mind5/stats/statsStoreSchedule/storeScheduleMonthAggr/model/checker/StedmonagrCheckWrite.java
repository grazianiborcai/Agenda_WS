package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StedmonagrCheckWrite extends ModelCheckerTemplateSimple<StedmonagrInfo> {

	public StedmonagrCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StedmonagrInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.calmonth 	== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_MTH_AGGR_MANDATORY_FIELD_EMPTY;
	}
}
