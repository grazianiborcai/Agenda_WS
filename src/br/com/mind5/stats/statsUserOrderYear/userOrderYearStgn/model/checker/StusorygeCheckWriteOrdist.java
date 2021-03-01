package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;

public final class StusorygeCheckWriteOrdist extends ModelCheckerTemplateSimple<StusorygeInfo> {

	public StusorygeCheckWriteOrdist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StusorygeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	|| 
			recordInfo.codOrder 	<= 0 	|| 
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_USER_YEAR_STGN_MANDATORY_FIELD_EMPTY;
	}
}
