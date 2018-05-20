package br.com.gda.business.material.model.checker;

import java.sql.Connection;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerMatGenField extends ModelCheckerTemplate<MatInfo> {
	private final boolean AUTO_GEN_FIELD_NOT_NULL = false;
	private final boolean EMPTY_AUTO_GEN_FIELD = true;
	
	public CheckerMatGenField() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codMat >= 0 )			
			return AUTO_GEN_FIELD_NOT_NULL;		
		
		return EMPTY_AUTO_GEN_FIELD;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AUTO_GENERATED_FIELD_IS_NOT_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AUTO_GENERATED_FIELD_IS_NOT_EMPTY;
	}
}
