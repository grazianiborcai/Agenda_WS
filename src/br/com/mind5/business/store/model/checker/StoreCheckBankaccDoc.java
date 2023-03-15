package br.com.mind5.business.store.model.checker;

import java.sql.Connection;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoreCheckBankaccDoc extends ModelCheckerTemplateSimple<StoreInfo> {
	
	public StoreCheckBankaccDoc(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.bankaccData.holderDocument == null ||
			recordInfo.companyData.cnpj 		  == null	)			
			return super.FAILED;
		
		
		if (recordInfo.bankaccData.holderDocument.equals(recordInfo.companyData.cnpj))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2);
		builder.addParam01(SystemCode.STORE);
		builder.addParam02(SystemCode.HOLDER_DOC_IS_DIFFERENT);

		return builder.build();
	}
}
