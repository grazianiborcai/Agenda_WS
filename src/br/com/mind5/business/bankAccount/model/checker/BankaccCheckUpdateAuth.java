package br.com.mind5.business.bankAccount.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BankaccCheckUpdateAuth extends ModelCheckerTemplateSimple<BankaccInfo> {

	public BankaccCheckUpdateAuth(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BankaccInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 			<= 0 	||
			 recordInfo.codStore			<= 0	||
			 recordInfo.codBank				<= 0	||
			 recordInfo.codBankHolderType	<= 0	||
			 recordInfo.codBankAccountType	<= 0	||
			 recordInfo.holderName			== null	||
			 recordInfo.branchNumber		== null	||
			 recordInfo.accountNumber		== null	||
			 recordInfo.accountCheckDigit	== null	||
			 recordInfo.holderDocument		== null	||
			 recordInfo.codLanguage			== null	||
			 recordInfo.username			== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.BANK_ACCOUNT);

		return builder.build();
	}
}
