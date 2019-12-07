package br.com.mind5.business.materialSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatarchCheckReadService extends ModelCheckerTemplateSimpleV2<MatarchInfo> {

	public MatarchCheckReadService(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codMat 		<= 0 	||
			recordInfo.username		== null ||
			recordInfo.codLanguage 	== null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
