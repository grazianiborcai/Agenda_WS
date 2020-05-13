package br.com.mind5.business.scheduleReserve.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchederveCheckRead extends ModelCheckerTemplateSimpleV2<SchederveInfo> {

	public SchederveCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchederveInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore	<= 0 	|| 
			 recordInfo.codMat		<= 0 	||
			 recordInfo.codEmployee	<= 0 	||
			 recordInfo.beginTime	== null	||
			 recordInfo.endTime		== null	||
			 recordInfo.date		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_RESERVE_MANDATORY_FIELD_EMPTY;
	}
}
