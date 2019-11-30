package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatCheckGenField_ extends ModelCheckerTemplateSimple_<MatInfo> {
	private final boolean AUTO_GEN_FIELD_NOT_NULL = false;
	private final boolean EMPTY_AUTO_GEN_FIELD = true;
	
	public MatCheckGenField_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codMat >= 0 )			
			return AUTO_GEN_FIELD_NOT_NULL;		
		
		return EMPTY_AUTO_GEN_FIELD;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AUTO_GENERATED_FIELD_IS_NOT_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AUTO_GENERATED_FIELD_IS_NOT_EMPTY;
	}
}
