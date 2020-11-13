package br.com.mind5.file.filePath.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FathCheckRead extends ModelCheckerTemplateSimple<FathInfo> {

	public FathCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FathInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codFilePath == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_PATH_MANDATORY_FIELD_EMPTY;
	}
}
