package br.com.mind5.business.calendarDateSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CalatarchCheckRead extends ModelCheckerTemplateSimpleV2<CalatarchInfo> {
	
	public CalatarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalatarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)	
			
			return super.FAILED;
		
		
		if ( recordInfo.weekYear > 0 )				
			return super.SUCCESS;
		
		
		if ( recordInfo.year  <= 0 	&&
			 recordInfo.month <= 0		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_DATE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
