package br.com.mind5.business.scheduleRange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class SchedageCheckRead extends ModelCheckerTemplateSimple<SchedageInfo> {

	public SchedageCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedageInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	|| 
			 recordInfo.codStore 		<= 0 	|| 
			 recordInfo.dateValidFrom	== null ||
			 recordInfo.dateValidTo		== null ||
			 recordInfo.timeValidFrom	== null ||
			 recordInfo.timeValidTo		== null ||
			 recordInfo.username		== null ||
			 recordInfo.codLanguage		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_OUTLIER_MANDATORY_FIELD_EMPTY;
	}
}
