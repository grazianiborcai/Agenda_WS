package br.com.mind5.businessContent.material.main.model.checker;

import java.sql.Connection;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatbcinCheckWrite extends ModelCheckerTemplateSimple<MatbcinInfo> {

	public MatbcinCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatbcinInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codStore 	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BC_MAT_MAIN_MANDATORY_FIELD_EMPTY;
	}
}
