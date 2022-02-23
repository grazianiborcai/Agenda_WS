package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;

public final class StordCheckReadMonth extends ModelCheckerTemplateSimple<StordInfo> {

	public StordCheckReadMonth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.calmonth 	== null	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_ODR_DAY_MANDATORY_FIELD_EMPTY;
	}
}
