package br.com.gda.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class MatmovCheckWrite extends ModelCheckerTemplateSimple_<MatmovInfo> {

	public MatmovCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatmovInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.username 	== null ||
			 recordInfo.codLanguage == null	||
			 recordInfo.codOwner	<= 0	||
			 recordInfo.codMatmov	<= 0		)			
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
