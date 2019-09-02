package br.com.gda.business.scheduleSearch.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SchedarchCheckRead extends ModelCheckerTemplateSimple<SchedarchInfo> {

	public SchedarchCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codSchedule > 0 	|| 
			 recordInfo.codOrder 	> 0		)
				
				return super.SUCCESS;
		
		
		if ( recordInfo.codStore 	<= 0 	|| 
			 recordInfo.codMat		<= 0 	||
			 recordInfo.codEmployee	<= 0 	||
			 recordInfo.date		== null ||
			 recordInfo.beginTime	== null ||
			 recordInfo.endTime		== null 	)
				
				return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
