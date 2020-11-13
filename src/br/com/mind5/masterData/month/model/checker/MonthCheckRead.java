package br.com.mind5.masterData.month.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MonthCheckRead extends ModelCheckerTemplateSimple<MonthInfo> {

	public MonthCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MonthInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.month 		<= 0 	||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MONTH_MANDATORY_FIELD_EMPTY;
	}
}
