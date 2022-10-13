package br.com.mind5.business.personLegal.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PeregCheckInsert extends ModelCheckerTemplateSimple<PeregInfo> {

	public PeregCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PeregInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner		<= 0	||
			 recordInfo.codStore		<= 0	||
			 recordInfo.personData 		== null ||
			 recordInfo.addressData 	== null ||
			 recordInfo.phoneData 		== null ||
			 recordInfo.username 		== null ||
			 recordInfo.codLanguage 	== null 	)
				
			return super.FAILED;
			
			
			return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.LEGAL_PERSON);

		return builder.build();
	}
}
