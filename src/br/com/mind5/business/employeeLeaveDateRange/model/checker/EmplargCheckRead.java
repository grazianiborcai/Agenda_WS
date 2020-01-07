package br.com.mind5.business.employeeLeaveDateRange.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmplargCheckRead extends ModelCheckerTemplateSimpleV2<EmplargInfo> {

	public EmplargCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplargInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codStore    	<= 0 	||
			recordInfo.codEmployee 	<= 0 	||
			recordInfo.validFrom	== null	||
			recordInfo.validTo		== null	||
			recordInfo.username		== null	||
			recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LDATE_RANGE_MANDATORY_FIELD_EMPTY;
	}
}
