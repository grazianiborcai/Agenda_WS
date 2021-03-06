package br.com.mind5.masterData.weekday.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class WeekdayCheckRead extends ModelCheckerTemplateSimple<WeekdayInfo> {
	
	public WeekdayCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(WeekdayInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codWeekday <= 0 	||
			recordInfo.codLanguage == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.WEEKDAY_MANDATORY_FIELD_EMPTY;
	}
}
