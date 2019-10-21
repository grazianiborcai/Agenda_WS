package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatCheckRead extends ModelCheckerTemplateSimple_<MatInfo> {

	public MatCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_MANDATORY_FIELD_EMPTY;
	}
}
