package br.com.gda.business.material.model.checker;

import java.sql.Connection;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class MatCheckWrite extends ModelCheckerTemplateSimple_<MatInfo> {

	public MatCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.txtMat		== null 	
			|| recordInfo.description 	== null	
			|| recordInfo.codType 		<= 0
			|| recordInfo.codMatCateg	<= 0
			|| recordInfo.priceUnit		<= 0
			|| recordInfo.codUnit		== null
			|| recordInfo.codGroup		<= 0
			|| recordInfo.codLanguage	== null
			|| recordInfo.username		== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_MANDATORY_FIELD_EMPTY;
	}
}
