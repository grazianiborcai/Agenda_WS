package br.com.mind5.business.person.model.checker;

import java.sql.Connection;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.DateValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PersonCheckBirthdate extends ModelCheckerTemplateSimple<PersonInfo> {

	public PersonCheckBirthdate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {
		if (DateValidator.validateBirthdate(recordInfo.birthDate) == super.FAILED)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_INVALID_F);
		builder.addParam01(SystemCode.PERSON);
		builder.addParam02(SystemCode.PERSON_BIRTHDATE);

		return builder.build();
	}
}
