package br.com.gda.business.materialText.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class MatextCheckWrite extends ModelCheckerTemplateSimple_<MatextInfo> {

	public MatextCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatextInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codMat		<= 0
			|| recordInfo.txtMat		== null
			|| recordInfo.codLanguage	== null
			|| recordInfo.description	== null
			|| recordInfo.username		== null	)
			
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
