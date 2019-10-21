package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatoreCheckHasMatock extends ModelCheckerTemplateSimple_<MatoreInfo> {

	public MatoreCheckHasMatock() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.quantityStock > 0	)			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_STORE_STOCK_NOT_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_STORE_STOCK_NOT_EMPTY;
	}
}
