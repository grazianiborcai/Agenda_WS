package br.com.mind5.masterData.timezone.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class TimezoneCheckRead extends ModelCheckerTemplateSimple<TimezoneInfo> {

	public TimezoneCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(TimezoneInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codTimezone == null	||
			 recordInfo.codLanguage == null 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TIMEZONE_MANDATORY_FIELD_EMPTY;
	}
}
