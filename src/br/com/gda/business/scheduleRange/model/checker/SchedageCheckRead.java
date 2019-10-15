package br.com.gda.business.scheduleRange.model.checker;

import java.sql.Connection;

import br.com.gda.business.scheduleRange.info.SchedageInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedageCheckRead extends ModelCheckerTemplateSimpleV2<SchedageInfo> {

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
