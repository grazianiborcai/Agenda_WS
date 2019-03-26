package br.com.gda.business.materialText.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatextCheckIsDefault extends ModelCheckerTemplateSimple<MatextInfo> {

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
