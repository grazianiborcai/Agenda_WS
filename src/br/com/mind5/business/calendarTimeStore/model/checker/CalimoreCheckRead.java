package br.com.mind5.business.calendarTimeStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CalimoreCheckRead extends ModelCheckerTemplateSimpleV2<CalimoreInfo> {

	public CalimoreCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalimoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore 	<= 0 	|| 
			 recordInfo.date 		== null	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_TIME_STORE_MANDATORY_FIELD_EMPTY;
	}
}
