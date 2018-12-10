package br.com.gda.business.snapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SnapCheckRead extends ModelCheckerTemplateSimple<SnapInfo> {

	public SnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
