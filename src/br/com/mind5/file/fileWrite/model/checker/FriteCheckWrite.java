package br.com.mind5.file.fileWrite.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class FriteCheckWrite extends ModelCheckerTemplateSimpleV2<FriteInfo> {

	public FriteCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FriteInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.fileUri == null )			
			return super.FAILED;
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_WRITE_MANDATORY_FIELD_EMPTY;
	}
}
