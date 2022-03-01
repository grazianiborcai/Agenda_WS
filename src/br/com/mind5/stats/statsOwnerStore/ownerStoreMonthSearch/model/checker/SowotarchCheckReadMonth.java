package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotarchCheckReadMonth extends ModelCheckerTemplateSimple<SowotarchInfo> {

	public SowotarchCheckReadMonth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowotarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.calmonth 	== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_STR_MTH_SRCH_MANDATORY_FIELD_EMPTY;
	}
}
