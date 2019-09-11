package br.com.gda.file.filePath.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FathCheckRead extends ModelCheckerTemplateSimple<FathInfo> {

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
