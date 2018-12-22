package br.com.gda.business.materialSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatSnapCheckWrite extends ModelCheckerTemplateSimple<MatSnapInfo> {

	public MatSnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatSnapInfo recordInfo, Connection conn, String schemaName) {	
		if (    recordInfo.codOwner 	<= 0 
			 || recordInfo.codMat		<= 0	)
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
