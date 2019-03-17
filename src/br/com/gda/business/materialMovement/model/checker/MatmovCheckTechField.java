package br.com.gda.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatmovCheckTechField extends ModelCheckerTemplateSimple<MatmovInfo> {
	
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
