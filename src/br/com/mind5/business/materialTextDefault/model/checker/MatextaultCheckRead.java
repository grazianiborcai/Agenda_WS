package br.com.mind5.business.materialTextDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatextaultCheckRead extends ModelCheckerTemplateSimpleV2<MatextaultInfo> {

	public MatextaultCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatextaultInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0	||
			recordInfo.codMat 	<= 0	||
			recordInfo.username	== null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_DEFAULT_MANDATORY_FIELD_EMPTY;
	}
}
