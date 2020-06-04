package br.com.mind5.business.calendarWeekYear.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CaleekyCheckRead extends ModelCheckerTemplateSimpleV2<CaleekyInfo> {
	
	public CaleekyCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CaleekyInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.weekYear	<= 0    ||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_WEEK_YEAR_MANDATORY_FIELD_EMPTY;
	}
}
