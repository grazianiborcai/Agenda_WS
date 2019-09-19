package br.com.gda.business.personSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersonapCheckWrite extends ModelCheckerTemplateSimple_<PersonapInfo> {

	public PersonapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||	
			 recordInfo.codPerson 	<= 0		)
			
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
