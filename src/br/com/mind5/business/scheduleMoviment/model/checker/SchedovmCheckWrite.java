package br.com.mind5.business.scheduleMoviment.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedovmCheckWrite extends ModelCheckerTemplateSimpleV2<SchedovmInfo> {

	public SchedovmCheckWrite(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_MOV_MANDATORY_FIELD_EMPTY;
	}
}
