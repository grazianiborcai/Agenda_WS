package br.com.mind5.business.personSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PersonapCheckWrite extends ModelCheckerTemplateSimple<PersonapInfo> {

	public PersonapCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0	||	
			 recordInfo.codPerson 	<= 0		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
