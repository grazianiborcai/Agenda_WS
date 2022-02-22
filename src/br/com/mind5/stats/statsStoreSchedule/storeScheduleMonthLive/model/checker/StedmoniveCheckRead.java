package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmoniveCheckRead extends ModelCheckerTemplateSimple<StedmoniveInfo> {

	public StedmoniveCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StedmoniveInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.calmonth 	== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_SCH_MTH_LIVE_MANDATORY_FIELD_EMPTY;
	}
}
