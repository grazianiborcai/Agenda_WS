package br.com.mind5.masterData.materialType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatypeCheckRead extends ModelCheckerTemplateSimpleV2<MatypeInfo> {
	
	public MatypeCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatypeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codType 	<= 0 	||
			 recordInfo.codLanguage == null 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TYPE_MANDATORY_FIELD_EMPTY;
	}
}
