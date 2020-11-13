package br.com.mind5.business.materialText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatextCheckIsDeleted extends ModelCheckerTemplateSimple<MatextInfo> {

	public MatextCheckIsDeleted(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatextInfo recordInfo, Connection conn, String schemaName) {			
		return recordInfo.isDeleted;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_NOT_FLAGGED_AS_DELETED;
	}
}
