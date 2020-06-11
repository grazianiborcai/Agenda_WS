package br.com.mind5.masterData.fileDocType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class FidoceCheckRead extends ModelCheckerTemplateSimpleV2<FidoceInfo> {

	public FidoceCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FidoceInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codFileDocType 	== null ||
			 recordInfo.codLanguage 	== null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_DOC_TYPE_MANDATORY_FIELD_EMPTY;
	}
}
