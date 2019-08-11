package br.com.gda.business.schedule.model.checker;

import java.sql.Connection;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class ScheduCheckWrite extends ModelCheckerTemplateSimple<ScheduInfo> {

	public ScheduCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(ScheduInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codCustomer	<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codMat		<= 0
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_MANDATORY_FIELD_EMPTY;
	}
}
