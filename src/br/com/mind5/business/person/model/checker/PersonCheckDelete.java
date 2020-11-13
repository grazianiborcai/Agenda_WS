package br.com.mind5.business.person.model.checker;

import java.sql.Connection;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PersonCheckDelete extends ModelCheckerTemplateSimple<PersonInfo> {
	
	public PersonCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	|| 
			 recordInfo.codPerson	<= 0	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null		)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_MANDATORY_FIELD_EMPTY;
	}
}
