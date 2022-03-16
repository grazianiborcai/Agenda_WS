package br.com.mind5.stats.statsOwnerDashboard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;

public final class SowashCheckRead extends ModelCheckerTemplateSimple<SowashInfo> {

	public SowashCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowashInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.calmonth 	== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_DASH_MANDATORY_FIELD_EMPTY;
	}
}
