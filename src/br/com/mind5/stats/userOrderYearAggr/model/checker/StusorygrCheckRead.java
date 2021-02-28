package br.com.mind5.stats.userOrderYearAggr.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrInfo;

public final class StusorygrCheckRead extends ModelCheckerTemplateSimple<StusorygrInfo> {

	public StusorygrCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StusorygrInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.codUser 		<= 0 	|| 	
			recordInfo.postingYear 	<= 0 	||			
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_AGGR_MANDATORY_FIELD_EMPTY;
	}
}
