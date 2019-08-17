package br.com.gda.business.scheduleLineSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SchedinapCheckHasOrder extends ModelCheckerTemplateSimple<SchedinapInfo> {

	public SchedinapCheckHasOrder() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedinapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrder <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_SNAPSHOT_HAS_NO_ORDER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_SNAPSHOT_HAS_NO_ORDER;
	}
}
