package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CompCheckDelete extends ModelCheckerTemplateSimple<CompInfo> {
	
	public CompCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0	||				
			 recordInfo.codCompany		<= 0 	||
			 recordInfo.username		== null		)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
