package br.com.mind5.business.materialText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatextCheckDeleteDefault extends ModelCheckerTemplateSimple_<MatextInfo> {

	public MatextCheckDeleteDefault() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatextInfo recordInfo, Connection conn, String schemaName) {			
		if (recordInfo.isDefault)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_TEXT_DEFAULT_CANT_BE_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_TEXT_DEFAULT_CANT_BE_DELETED;
	}
}
