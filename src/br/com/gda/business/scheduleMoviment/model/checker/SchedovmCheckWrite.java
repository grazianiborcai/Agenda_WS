package br.com.gda.business.scheduleMoviment.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SchedovmCheckWrite extends ModelCheckerTemplateSimple<SchedovmInfo> {

	public SchedovmCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedovmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 			<= 0 	|| 
			 recordInfo.codStore 			<= 0 	|| 
			 recordInfo.codEmployee 		<= 0 	|| 
			 recordInfo.codMat 				<= 0 	|| 
			 recordInfo.year 				<= 0 	|| 
			 recordInfo.month 				<= 0 	|| 
			 recordInfo.day 				<= 0 	|| 
			 recordInfo.date				== null	||
			 recordInfo.codScheduleStatus	== null)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_MOV_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_MOV_MANDATORY_FIELD_EMPTY;
	}
}
