package br.com.mind5.business.materialTextSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatextsnapCheckWrite extends ModelCheckerTemplateSimple_<MatextsnapInfo> {

	public MatextsnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatextsnapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codMat		<= 0
			|| recordInfo.codSnapshot	<= 0	)
			
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
