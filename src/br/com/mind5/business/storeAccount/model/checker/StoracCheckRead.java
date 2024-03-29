package br.com.mind5.business.storeAccount.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoracCheckRead extends ModelCheckerTemplateSimple<StoracInfo> {

	public StoracCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoracInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_ACCOUNT_MANDATORY_FIELD_EMPTY;
	}
}
