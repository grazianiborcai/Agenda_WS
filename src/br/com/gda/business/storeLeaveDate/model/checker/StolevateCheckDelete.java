package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class StolevateCheckDelete extends ModelCheckerTemplateSimple_<StolevateInfo> {
	private final boolean KEY_NOT_NULL = true;
	private final boolean EMPTY_KEY = false;
	
	public StolevateCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StolevateInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 		<= 0 
			 || recordInfo.codStore  		<= 0 
			 || recordInfo.dateValidFrom	== null
			 || recordInfo.timeValidFrom	== null
			 || recordInfo.username			== null
			 || recordInfo.codLanguage		== null	)			
			return EMPTY_KEY;		
		
		return KEY_NOT_NULL;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
