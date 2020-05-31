package br.com.mind5.business.calendarMoon.model.checker;

import java.sql.Connection;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MooncalCheckRead extends ModelCheckerTemplateSimpleV2<MooncalInfo> {
	
	public MooncalCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MooncalInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.moonDate	== null ||
			 recordInfo.codLanguage == null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_CALENDAR_MANDATORY_FIELD_EMPTY;
	}
}
