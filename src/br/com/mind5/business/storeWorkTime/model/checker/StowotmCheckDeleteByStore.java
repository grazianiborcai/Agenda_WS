package br.com.mind5.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class StowotmCheckDeleteByStore extends ModelCheckerTemplateSimpleV2<StowotmInfo> {
	
	public StowotmCheckDeleteByStore(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StowotmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.username	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_MANDATORY_FIELD_EMPTY;
	}
}
