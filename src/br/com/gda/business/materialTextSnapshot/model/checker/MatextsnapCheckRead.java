package br.com.gda.business.materialTextSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatextsnapCheckRead extends ModelCheckerTemplateSimple<MatextsnapInfo> {

	public MatextsnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatextsnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0	||
			recordInfo.codSnapshot 	<= 0	||
			recordInfo.codMat 		<= 0		)			
			
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
