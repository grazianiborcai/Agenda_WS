package br.com.mind5.business.pet.model.checker;

import java.sql.Connection;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.common.StringValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PetCheckSafeNote extends ModelCheckerTemplateSimple<PetInfo> {

	public PetCheckSafeNote(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PetInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.petNote == null)
			return super.SUCCESS;
		
		if (StringValidator.validateSafe(recordInfo.petNote) == super.SUCCESS)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_CONTAIN_INVALID_CHAR);
		builder.addParam01(SystemCode.PET);
		builder.addParam02(SystemCode.GEN_NOTE);

		return builder.build();
	}
}
