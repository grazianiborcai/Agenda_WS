package br.com.gda.business.materialStock.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.MatmovType;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatockCheckInsert extends ModelCheckerTemplateSimple<MatockInfo> {

	public MatockCheckInsert() {
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
