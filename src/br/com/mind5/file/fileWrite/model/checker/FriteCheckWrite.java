package br.com.mind5.file.fileWrite.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class FriteCheckWrite extends ModelCheckerTemplateSimple_<FriteInfo> {

	public FriteCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FriteInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.fileUri == null)			
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
