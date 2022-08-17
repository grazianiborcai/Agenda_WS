package br.com.mind5.business.person.model.checker;

import java.sql.Connection;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.common.StringValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PersonCheckSafeNameDisplay extends ModelCheckerTemplateSimple<PersonInfo> {

	public PersonCheckSafeNameDisplay(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PersonInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.nameDisplay == null)
			return super.SUCCESS;
		
		if (StringValidator.validateSafe(recordInfo.nameDisplay) == super.SUCCESS)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_CONTAIN_INVALID_CHAR);
		builder.addParam01(SystemCode.PERSON);
		builder.addParam02(SystemCode.PERSON_NAME_DISPLAY);

		return builder.build();
	}
}
