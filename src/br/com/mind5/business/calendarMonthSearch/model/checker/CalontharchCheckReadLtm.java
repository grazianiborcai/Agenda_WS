package br.com.mind5.business.calendarMonthSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CalontharchCheckReadLtm extends ModelCheckerTemplateSimple<CalontharchInfo> {
	
	public CalontharchCheckReadLtm(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalontharchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.calmonth 	== null	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_MONTH_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
