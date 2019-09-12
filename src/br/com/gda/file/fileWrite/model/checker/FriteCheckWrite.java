package br.com.gda.file.fileWrite.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileWrite.info.FriteInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FriteCheckWrite extends ModelCheckerTemplateSimple<FriteInfo> {

	public FriteCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FriteInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.fileFullName== null	)
			
			return super.FAILED;
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.FILE_WRITE_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.FILE_WRITE_MANDATORY_FIELD_EMPTY;
	}
}
