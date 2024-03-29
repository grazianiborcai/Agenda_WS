package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;

public final class StefilonCheckWrite extends ModelCheckerTemplateSimple<StefilonInfo> {

	public StefilonCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StefilonInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore 	<= 0 	||
			recordInfo.calmonth 	== null	||
			recordInfo.codLanguage 	== null	||
			recordInfo.username 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STR_PRF_MTH_MANDATORY_FIELD_EMPTY;
	}
}
