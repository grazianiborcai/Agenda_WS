package br.com.mind5.business.employeeWorkTimeOutlier.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmpwoutCheckRead extends ModelCheckerTemplateSimpleV2<EmpwoutInfo> {

	public EmpwoutCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpwoutInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codWeekday	<= 0 	||
			recordInfo.codLanguage	== null ||
			recordInfo.username		== null ||
			recordInfo.beginTime	== null ||
			recordInfo.endTime		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WT_OUT_MANDATORY_FIELD_EMPTY;
	}	
}
