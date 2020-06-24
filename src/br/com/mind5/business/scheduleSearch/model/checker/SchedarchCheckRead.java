package br.com.mind5.business.scheduleSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedarchCheckRead extends ModelCheckerTemplateSimpleV2<SchedarchInfo> {

	public SchedarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		
		if ( recordInfo.codSchedule > 0 	|| 
			 recordInfo.codOrder 	> 0 		)
			
			return super.SUCCESS;
		
		
		
		if ( recordInfo.codStore 	<= 0 	&& 
			 recordInfo.codMat		<= 0 	&&
			 recordInfo.codEmployee	<= 0 	&&
			 recordInfo.codUser		<= 0 		)
				
			return super.FAILED;	
		
		
		if ( recordInfo.year		<= 0 	&&
			 recordInfo.month		<= 0 	&&
			 recordInfo.date		== null 	)
				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
