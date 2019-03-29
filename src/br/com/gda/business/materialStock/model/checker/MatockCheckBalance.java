package br.com.gda.business.materialStock.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatockCheckBalance extends ModelCheckerTemplateSimple<MatockInfo> {

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
