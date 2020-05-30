package br.com.mind5.business.calendarDate.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CalateCheckRead extends ModelCheckerTemplateSimpleV2<CalateInfo> {
	
	public CalateCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalateInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.date		== null ||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_DATE_MANDATORY_FIELD_EMPTY;
	}
}
