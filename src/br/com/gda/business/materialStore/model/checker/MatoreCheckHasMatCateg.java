package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class MatoreCheckHasMatCateg extends ModelCheckerTemplateSimple_<MatoreInfo> {

	public MatoreCheckHasMatCateg() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codMatCateg <= 0 )
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_STORE_MAT_CATEG_IS_NULL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_STORE_MAT_CATEG_IS_NULL;
	}
}
