package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAdd extends ModelCheckerTemplateSimpleV2<CremoipInfo> {

	public CremoipCheckAdd(ModelCheckerOption option) {
		super(option);
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_MANDATORY_FIELD_EMPTY;
	}	
}
