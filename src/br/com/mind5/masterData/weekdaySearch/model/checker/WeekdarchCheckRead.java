package br.com.mind5.masterData.weekdaySearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class WeekdarchCheckRead extends ModelCheckerTemplateSimple<WeekdarchInfo> {
	
	public WeekdarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(WeekdarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.WEEKDAY_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
