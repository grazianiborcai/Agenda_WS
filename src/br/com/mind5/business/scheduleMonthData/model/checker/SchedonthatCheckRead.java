package br.com.mind5.business.scheduleMonthData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SchedonthatCheckRead extends ModelCheckerTemplateSimple<SchedonthatInfo> {

	public SchedonthatCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedonthatInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	|| 
			 recordInfo.codStore 	<= 0 	|| 
			 recordInfo.year 		<= 0 	|| 
			 recordInfo.month 		<= 0 	|| 
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_MONTH_DATA_FIELD_EMPTY;
	}
}
