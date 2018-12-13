package br.com.gda.business.personSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PersonSnapCheckWrite extends ModelCheckerTemplateSimple<PersonSnapInfo> {

	public PersonSnapCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonSnapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0	
			|| recordInfo.codPerson 		<= 0 )
			
			return FAILED;
		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MANDATORY_FIELD_EMPTY;
	}
}
