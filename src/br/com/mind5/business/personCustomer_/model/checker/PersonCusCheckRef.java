package br.com.mind5.business.personCustomer_.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class PersonCusCheckRef extends ModelCheckerTemplateSimple_<PersonCusInfo> {

	public PersonCusCheckRef() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonCusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.email == null	&&
			 recordInfo.cpf	  == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_CUS_WITHOUT_REFERENCE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_CUS_WITHOUT_REFERENCE;
	}
}
