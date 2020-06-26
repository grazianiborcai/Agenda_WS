package br.com.mind5.business.storeSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StorapCheckHasAddress extends ModelCheckerTemplateSimpleV2<StorapInfo> {

	public StorapCheckHasAddress(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codAddress <= 0)				
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
