package br.com.mind5.business.scheduleSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SchedarchCheckRead extends ModelCheckerTemplateSimple<SchedarchInfo> {

	public SchedarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codSchedule <= 0 	&& 
			 recordInfo.codOrder 	<= 0 	&& 
			 recordInfo.codStore 	<= 0 	&& 
			 recordInfo.codMat		<= 0 	&&
			 recordInfo.codEmployee	<= 0 	&&
			 recordInfo.date		== null 	)
				
				return super.FAILED;	
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
