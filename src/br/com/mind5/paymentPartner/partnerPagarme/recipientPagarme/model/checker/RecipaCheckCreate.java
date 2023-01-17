package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;

public final class RecipaCheckCreate extends ModelCheckerTemplateSimple<RecipaInfo> {

	public RecipaCheckCreate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RecipaInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.name 		== null	||
			recordInfo.email 		== null	||
			recordInfo.document 	== null	||
			recordInfo.code 		== null	||
			recordInfo.codLanguage	== null		)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.PAGARME_RECIPIENT_CREATION);

		return builder.build();
	}
}
