package br.com.mind5.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatmovCheckTechField extends ModelCheckerTemplateSimple_<MatmovInfo> {
	
	public MatmovCheckTechField() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatmovInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codMatmov >= 0 )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_MOV_TECH_FIELD_SHOULD_BE_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_MOV_TECH_FIELD_SHOULD_BE_EMPTY;
	}
}
