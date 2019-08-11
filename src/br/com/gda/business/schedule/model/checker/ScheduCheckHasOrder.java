package br.com.gda.business.schedule.model.checker;

import java.sql.Connection;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class ScheduCheckHasOrder extends ModelCheckerTemplateSimple<ScheduInfo> {

	public ScheduCheckHasOrder() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(ScheduInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrder <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_HAS_NO_ORDER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_HAS_NO_ORDER;
	}
}
