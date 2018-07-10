package br.com.gda.business.material.model.checker;

import java.sql.Connection;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatCheckWrite extends ModelCheckerTemplateSimple<MatInfo> {

	public MatCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.txtMat		== null 	
			|| recordInfo.description 	== null	
			|| recordInfo.codType 		<= 0
			|| recordInfo.codCategory	<= 0
			|| recordInfo.price			<= 0
			|| recordInfo.priceUnit		<= 0
			|| recordInfo.codCurr		== null
			|| recordInfo.codUnit		== null
			|| recordInfo.codGroup		<= 0
			|| recordInfo.codLanguage	== null	)
			
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
