package br.com.gda.business.personList.model.checker;

import java.sql.Connection;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersolisCheckRead extends ModelCheckerTemplateSimple_<PersolisInfo> {

	public PersolisCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersolisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner  	<= 0 	||
			 recordInfo.codPerson 	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)			
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
