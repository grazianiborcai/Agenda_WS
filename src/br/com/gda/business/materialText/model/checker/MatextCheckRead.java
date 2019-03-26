package br.com.gda.business.materialText.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatextCheckRead extends ModelCheckerTemplateSimple<MatextInfo> {

	public MatextCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatextInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0	||
			recordInfo.codMat 	<= 0		)			
			
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
