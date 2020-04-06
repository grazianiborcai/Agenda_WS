package br.com.mind5.business.scheduleMoviment.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedovmCheckHasCounter extends ModelCheckerTemplateSimpleV2<SchedovmInfo> {

	public SchedovmCheckHasCounter(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedovmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.confirmed 	!= 0 || 
			 recordInfo.waiting 	!= 0 || 
			 recordInfo.counter 	!= 0	)
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_MOV_MANDATORY_FIELD_EMPTY;
	}
}
