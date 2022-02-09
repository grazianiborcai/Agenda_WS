package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;

public final class SowedulCheckHasData extends ModelCheckerTemplateSimple<SowedulInfo> {

	public SowedulCheckHasData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowedulInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hasData )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_SCHED_MANDATORY_FIELD_EMPTY;
	}
}
