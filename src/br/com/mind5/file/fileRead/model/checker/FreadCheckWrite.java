package br.com.mind5.file.fileRead.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FreadCheckWrite extends ModelCheckerTemplateSimple<FreadInfo> {

	public FreadCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FreadInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.fileUri == null )			
			return super.FAILED;
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_READ_MANDATORY_FIELD_EMPTY;
	}
}
