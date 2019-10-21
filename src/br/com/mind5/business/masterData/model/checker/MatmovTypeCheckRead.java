package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatmovTypeCheckRead extends ModelCheckerTemplateSimple_<MatmovTypeInfo> {
	
	public MatmovTypeCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatmovTypeInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_MOV_TYPE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_MOV_TYPE_MANDATORY_FIELD_EMPTY;
	}
}
