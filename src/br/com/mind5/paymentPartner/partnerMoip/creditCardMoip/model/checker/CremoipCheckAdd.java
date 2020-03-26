package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAdd extends ModelCheckerTemplateSimple<CremoipInfo> {

	public CremoipCheckAdd(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 			<= 0 	||
			recordInfo.codPayCustomer		<= 0 	||
			recordInfo.codAddressSnapshot 	<= 0 	||
			recordInfo.codPhoneSnapshot 	<= 0 	||
			recordInfo.expirationMonth 		== null	||
			recordInfo.expirationYear 		== null	||
			recordInfo.cardNumber 			== null	||
			recordInfo.cardCvc 				== null	||
			recordInfo.nameHolder 			== null	||
			recordInfo.birthdateHolder 		== null	||
			recordInfo.cpfHolder 			== null	||
			recordInfo.username				== null	||
			recordInfo.codLanguage			== null		)
			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_MANDATORY_FIELD_EMPTY;
	}	
}
