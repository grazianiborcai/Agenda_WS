package br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;

public final class SowalCheckHasData extends ModelCheckerTemplateSimple<SowalInfo> {

	public SowalCheckHasData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowalInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hasData )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWNER_SALE_MANDATORY_FIELD_EMPTY;
	}
}
