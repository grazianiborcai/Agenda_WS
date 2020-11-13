package br.com.mind5.masterData.fileDocTypeSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FidocarchCheckRead extends ModelCheckerTemplateSimple<FidocarchInfo> {

	public FidocarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FidocarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage == null )
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_DOC_TYPE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
