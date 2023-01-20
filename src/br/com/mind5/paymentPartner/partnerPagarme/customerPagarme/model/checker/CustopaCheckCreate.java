package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;

public final class CustopaCheckCreate extends ModelCheckerTemplateSimple<CustopaInfo> {

	public CustopaCheckCreate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CustopaInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.name 		== null	||
			recordInfo.email 		== null	||
			recordInfo.codLanguage	== null		)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.PAGARME_CUSTOMER);

		return builder.build();
	}
}
