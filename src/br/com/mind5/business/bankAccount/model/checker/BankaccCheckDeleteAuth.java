package br.com.mind5.business.bankAccount.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BankaccCheckDeleteAuth extends ModelCheckerTemplateSimple<BankaccInfo> {

	public BankaccCheckDeleteAuth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BankaccInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0 	||
			 recordInfo.codStore 		<= 0 	||
			 recordInfo.codBankAccount	<= 0	||
			 recordInfo.codLanguage		== null	||
			 recordInfo.username		== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.BANK_ACCOUNT);

		return builder.build();
	}
}
