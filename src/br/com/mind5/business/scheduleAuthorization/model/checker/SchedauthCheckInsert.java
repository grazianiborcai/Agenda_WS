package br.com.mind5.business.scheduleAuthorization.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedauthCheckInsert extends ModelCheckerTemplateSimpleV2<SchedauthInfo> {

	public SchedauthCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedauthInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore 	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_AUTH_MANDATORY_FIELD_EMPTY;
	}
}
