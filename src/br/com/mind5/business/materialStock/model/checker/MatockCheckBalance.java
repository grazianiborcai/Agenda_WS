package br.com.mind5.business.materialStock.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatockCheckBalance extends ModelCheckerTemplateSimpleV2<MatockInfo> {

	public MatockCheckBalance(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatockInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.quantityStock < 0 )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STOCK_NO_BALANCE;
	}
}
