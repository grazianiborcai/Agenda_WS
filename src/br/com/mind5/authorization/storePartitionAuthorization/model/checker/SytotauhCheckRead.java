package br.com.mind5.authorization.storePartitionAuthorization.model.checker;

import java.sql.Connection;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SytotauhCheckRead extends ModelCheckerTemplateSimpleV2<SytotauhInfo> {

	public SytotauhCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SytotauhInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)		
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PART_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
