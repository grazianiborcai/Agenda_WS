package br.com.mind5.stats.statsOwnerUser.ownerUser.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;

public final class SowusCheckHasData extends ModelCheckerTemplateSimple<SowusInfo> {

	public SowusCheckHasData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hasData )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_USER_MANDATORY_FIELD_EMPTY;
	}
}
