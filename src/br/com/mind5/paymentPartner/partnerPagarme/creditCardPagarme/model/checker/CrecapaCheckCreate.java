package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info.CrecapaInfo;

public final class CrecapaCheckCreate extends ModelCheckerTemplateSimple<CrecapaInfo> {

	public CrecapaCheckCreate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecapaInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codCreditCard 	<= 0	||
			recordInfo.customerId 		== null	||
			recordInfo.cardNumber 		== null	||
			recordInfo.expirationMonth 	== null	||
			recordInfo.expirationYear 	== null	||
			recordInfo.cardCvc 			== null	||
			recordInfo.codLanguage		== null		)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.PAGARME_CREDIT_CARD);

		return builder.build();
	}
}
