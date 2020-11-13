package br.com.mind5.business.materialCatalogue.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatogueCheckRead extends ModelCheckerTemplateSimple<MatogueInfo> {

	public MatogueCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatogueInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codStore    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_CATALOGUE_MANDATORY_FIELD_EMPTY;
	}
}
