package br.com.gda.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAdd extends ModelCheckerTemplateSimple<CremoipInfo> {

	public CremoipCheckAdd() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.expirationMonth 	== null		||
			recordInfo.expirationYear 	== null		||
			recordInfo.cardNumber 		== null		||
			recordInfo.cardCvc 			== null		||
			recordInfo.nameHolder 		== null		||
			recordInfo.birthdateHolder 	== null		||
			recordInfo.cpfHolder 		== null			)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
