package br.com.mind5.masterData.materialGroup.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoupCheckRead extends ModelCheckerTemplateSimple<MatoupInfo> {

	public MatoupCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoupInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codGroup 	<= 0 	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_GROUP_MANDATORY_FIELD_EMPTY;
	}
}
