package br.com.mind5.stats.statsOwnerStore.ownerStore.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;

public final class SowotCheckHasData extends ModelCheckerTemplateSimple<SowotInfo> {

	public SowotCheckHasData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hasData )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_STORE_MANDATORY_FIELD_EMPTY;
	}
}
