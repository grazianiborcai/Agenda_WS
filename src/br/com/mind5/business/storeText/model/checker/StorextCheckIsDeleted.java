package br.com.mind5.business.storeText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextCheckIsDeleted extends ModelCheckerTemplateSimple<StorextInfo> {

	public StorextCheckIsDeleted(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextInfo recordInfo, Connection conn, String schemaName) {			
		return recordInfo.isDeleted;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_NOT_FLAGGED_AS_DELETED;
	}
}
