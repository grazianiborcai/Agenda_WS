package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatCheckHasMatext extends ModelCheckerTemplateSimple<MatInfo> {

	public MatCheckHasMatext(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {			
		if (recordInfo.matextes == null)
			return super.FAILED;
		
		if (recordInfo.matextes.isEmpty())
			return super.FAILED;		
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MANDATORY_FIELD_EMPTY;
	}
}
