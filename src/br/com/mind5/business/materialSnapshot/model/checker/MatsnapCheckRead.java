package br.com.mind5.business.materialSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatsnapCheckRead extends ModelCheckerTemplateSimple_<MatsnapInfo> {

	public MatsnapCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatsnapInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 		||
			recordInfo.codSnapshot 	<= 0 		||
			recordInfo.codMat 		<= 0 		||
			recordInfo.codLanguage  == null			)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
