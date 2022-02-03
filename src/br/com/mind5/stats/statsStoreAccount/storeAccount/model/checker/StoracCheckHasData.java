package br.com.mind5.stats.statsStoreAccount.storeAccount.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;

public final class StoracCheckHasData extends ModelCheckerTemplateSimple<StoracInfo> {

	public StoracCheckHasData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.hasData )
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_ACCT_MANDATORY_FIELD_EMPTY;
	}
}
