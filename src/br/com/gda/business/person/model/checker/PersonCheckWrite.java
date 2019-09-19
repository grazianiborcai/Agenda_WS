package br.com.gda.business.person.model.checker;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class PersonCheckWrite extends ModelCheckerTemplateSimple_<PersonInfo> {

	public PersonCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0  					
			|| recordInfo.codGender 		<= 0	
			|| recordInfo.username			== null
			|| recordInfo.name 				== null
			|| recordInfo.codLanguage		== null
			|| recordInfo.codEntityCateg	== null )
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PERSON_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PERSON_MANDATORY_FIELD_EMPTY;
	}
}
