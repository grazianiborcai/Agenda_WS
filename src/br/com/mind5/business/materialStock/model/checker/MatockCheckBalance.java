package br.com.mind5.business.materialStock.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatockCheckBalance extends ModelCheckerTemplateSimple_<MatockInfo> {

	public MatockCheckBalance() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatockInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.quantityStock < 0 )				
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_STOCK_NO_BALANCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_STOCK_NO_BALANCE;
	}
}
