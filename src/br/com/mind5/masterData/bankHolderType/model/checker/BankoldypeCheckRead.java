package br.com.mind5.masterData.bankHolderType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BankoldypeCheckRead extends ModelCheckerTemplateSimple<BankoldypeInfo> {
	
	public BankoldypeCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BankoldypeInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codBankHolderType <= 0 	||
			 recordInfo.codLanguage    == null 	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.BANK_HOLDER_TYPE);

		return builder.build();
	}
}
