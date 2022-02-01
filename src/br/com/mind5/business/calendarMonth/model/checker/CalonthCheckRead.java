package br.com.mind5.business.calendarMonth.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CalonthCheckRead extends ModelCheckerTemplateSimple<CalonthInfo> {
	
	public CalonthCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CalonthInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.calmonth	== null ||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_MONTH_MANDATORY_FIELD_EMPTY;
	}
}
