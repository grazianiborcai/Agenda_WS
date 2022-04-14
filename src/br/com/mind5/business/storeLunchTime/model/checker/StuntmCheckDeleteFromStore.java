package br.com.mind5.business.storeLunchTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StuntmCheckDeleteFromStore extends ModelCheckerTemplateSimple<StuntmInfo> {
	
	public StuntmCheckDeleteFromStore(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StuntmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codStore 	<= 0	||
			 recordInfo.username	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LTIME_MANDATORY_FIELD_EMPTY;
	}
}
