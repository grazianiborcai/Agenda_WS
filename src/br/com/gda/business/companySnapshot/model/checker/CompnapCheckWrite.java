package br.com.gda.business.companySnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CompnapCheckWrite extends ModelCheckerTemplateSimple<CompnapInfo> {

	public CompnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CompnapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 	 <= 0	
			|| recordInfo.codCompany <= 0  )
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.COMPANY_SNAP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.COMPANY_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
