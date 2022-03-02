package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

public final class SowusarchCheckRead extends ModelCheckerTemplateSimple<SowusarchInfo> {

	public SowusarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowusarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_USR_MTH_SRCH_MANDATORY_FIELD_EMPTY;
	}
}
