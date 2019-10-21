package br.com.mind5.business.materialText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatextCheckIsDefault extends ModelCheckerTemplateSimple_<MatextInfo> {

	public MatextCheckIsDefault() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatextInfo recordInfo, Connection conn, String schemaName) {			
		return recordInfo.isDefault;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_TEXT_NOT_DEFAULT;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_TEXT_NOT_DEFAULT;
	}
}
