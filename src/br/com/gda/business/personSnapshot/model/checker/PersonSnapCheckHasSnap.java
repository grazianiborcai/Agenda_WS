package br.com.gda.business.personSnapshot.model.checker;

import java.sql.Connection;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class PersonSnapCheckHasSnap extends ModelCheckerTemplateSimple<PersonSnapInfo> {

	public PersonSnapCheckHasSnap() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonSnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codSnapshot	<= 0 )				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_SNAPSHOT_IS_NULL;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_SNAPSHOT_IS_NULL;
	}
}
