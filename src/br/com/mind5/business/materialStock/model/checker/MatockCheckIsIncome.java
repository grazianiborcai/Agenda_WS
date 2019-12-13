package br.com.mind5.business.materialStock.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatmovType;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatockCheckIsIncome extends ModelCheckerTemplateSimple_<MatockInfo> {

	public MatockCheckIsIncome() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatockInfo recordInfo, Connection conn, String schemaName) {	
		if (MatmovType.INCOME.getCodMatmovType() == recordInfo.codMatmovType)
			return super.SUCCESS;
			
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_MOV_TYPE_NOT_ALLOWED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_MOV_TYPE_NOT_ALLOWED;
	}
}
