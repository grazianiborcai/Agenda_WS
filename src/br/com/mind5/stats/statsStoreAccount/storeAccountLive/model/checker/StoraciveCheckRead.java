package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

public final class StoraciveCheckRead extends ModelCheckerTemplateSimple<StoraciveInfo> {

	public StoraciveCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoraciveInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.calmonth 	== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_ACCT_LIVE_MANDATORY_FIELD_EMPTY;
	}
}
