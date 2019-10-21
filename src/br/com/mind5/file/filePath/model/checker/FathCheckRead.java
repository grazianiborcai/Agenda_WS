package br.com.mind5.file.filePath.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class FathCheckRead extends ModelCheckerTemplateSimple_<FathInfo> {

	public FathCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FathInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codFilePath == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.FILE_PATH_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.FILE_PATH_MANDATORY_FIELD_EMPTY;
	}
}
