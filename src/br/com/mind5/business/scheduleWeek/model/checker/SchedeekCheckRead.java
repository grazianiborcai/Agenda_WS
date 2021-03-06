package br.com.mind5.business.scheduleWeek.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SchedeekCheckRead extends ModelCheckerTemplateSimple<SchedeekInfo> {

	public SchedeekCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedeekInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore 	<= 0 	|| 
			 recordInfo.weekYear 	<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_WEEK_FIELD_EMPTY;
	}
}
