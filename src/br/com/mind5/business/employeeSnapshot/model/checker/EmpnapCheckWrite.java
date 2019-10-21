package br.com.mind5.business.employeeSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmpnapCheckWrite extends ModelCheckerTemplateSimple_<EmpnapInfo> {

	public EmpnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(EmpnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codEmployee <= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.EMP_SNAP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMP_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
