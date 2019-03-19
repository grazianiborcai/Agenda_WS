package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatoreCheckRead extends ModelCheckerTemplateSimple<MatoreInfo> {

	public MatoreCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatoreInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0
			|| recordInfo.codStore    <= 0
			|| recordInfo.codLanguage == null
			|| recordInfo.username	  == null	)			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
