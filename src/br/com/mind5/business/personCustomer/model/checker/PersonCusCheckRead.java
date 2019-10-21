package br.com.mind5.business.personCustomer.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class PersonCusCheckRead extends ModelCheckerTemplateSimple_<PersonCusInfo> {

	public PersonCusCheckRead() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonCusInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner <= 0 )			
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
