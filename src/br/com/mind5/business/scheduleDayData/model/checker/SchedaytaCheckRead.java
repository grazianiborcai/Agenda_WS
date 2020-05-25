package br.com.mind5.business.scheduleDayData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedaytaCheckRead extends ModelCheckerTemplateSimpleV2<SchedaytaInfo> {

	public SchedaytaCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedaytaInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codSchedule <= 0 	|| 
			 recordInfo.username	== null ||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_DAY_DATA_MANDATORY_FIELD_EMPTY;
	}
}
