package br.com.mind5.masterData.materialUnit.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatunitCheckRead extends ModelCheckerTemplateSimpleV2<MatunitInfo> {

	public MatunitCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatunitInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codUnit 	== null ||
			 recordInfo.codLanguage == null 	)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_UNIT_MANDATORY_FIELD_EMPTY;
	}
}
