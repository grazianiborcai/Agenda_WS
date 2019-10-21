package br.com.mind5.business.scheduleLineSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class SchedinapCheckWrite extends ModelCheckerTemplateSimple_<SchedinapInfo> {

	public SchedinapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedinapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codSchedule	<= 0 
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
