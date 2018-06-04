package br.com.gda.business.materialEmployee.model.chekcer;

import java.sql.Connection;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class MatEmpCheckWrite extends ModelCheckerTemplate<MatEmpInfo> {

	public MatEmpCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatEmpInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 	
			|| recordInfo.codStore 			<= 0
			|| recordInfo.codEmployee		<= 0  	
			|| recordInfo.codMat			<= 0	)
			
			return RESULT_FAILED;
		
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
