package br.com.mind5.masterData.dayParting.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DaypartCheckRead extends ModelCheckerTemplateSimple<DaypartInfo> {
	
	public DaypartCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DaypartInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codDaypart  <= 0	||
			 recordInfo.codLanguage == null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DAYPART_MANDATORY_FIELD_EMPTY;
	}
}
