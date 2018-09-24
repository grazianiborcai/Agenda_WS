package br.com.gda.business.reserve.model.checker;

import java.sql.Connection;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class ReserveCheckRead extends ModelCheckerTemplateSimple<ReserveInfo> {

	public ReserveCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(ReserveInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore	<= 0 	|| 
			 recordInfo.codMat		<= 0 	||
			 recordInfo.codEmployee	<= 0 	||
			 recordInfo.beginTime	== null	||
			 recordInfo.endTime		== null	||
			 recordInfo.date		== null		)
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
