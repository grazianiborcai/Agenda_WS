package br.com.mind5.business.materialMovement.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatmovCheckInsert extends ModelCheckerTemplateSimple_<MatmovInfo> {

	public MatmovCheckInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatmovInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.username 		== null 					||
			 recordInfo.codLanguage 	== null						||
			 recordInfo.codOwner		<= 0						||
			 recordInfo.codStore		<= 0						||
			 recordInfo.codMat			<= 0						||
			 recordInfo.codMatmovType	== DefaultValue.character() ||
			 recordInfo.quantity		<= 0	)			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
