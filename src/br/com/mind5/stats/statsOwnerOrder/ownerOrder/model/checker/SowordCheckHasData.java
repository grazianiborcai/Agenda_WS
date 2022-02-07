package br.com.mind5.stats.statsOwnerOrder.ownerOrder.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerOrder.ownerOrder.info.SowordInfo;

public final class SowordCheckHasData extends ModelCheckerTemplateSimple<SowordInfo> {

	public SowordCheckHasData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowordInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hasData )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_ORDER_MANDATORY_FIELD_EMPTY;
	}
}
