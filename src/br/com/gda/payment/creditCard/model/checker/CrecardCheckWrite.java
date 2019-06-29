package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class CrecardCheckWrite extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 			<= 0 	||	
			 recordInfo.codAddressHolder	<= 0 	||
			 recordInfo.codPhoneHolder		<= 0 	||
			 recordInfo.expirationMonth		== null ||			 
			 recordInfo.expirationYear		== null ||
			 recordInfo.cardNumber			== null ||
			 recordInfo.cardCvc				== null ||
			 recordInfo.birthdateHolder		== null ||
			 recordInfo.cpfHolder			== null ||			 
			 recordInfo.codLanguage 		== null ||
			 recordInfo.username 			== null 	)
			
			return super.FAILED;
		
		
		
		if ( recordInfo.codPayCustomer	<= 0 	&&
			 recordInfo.codPayPartner	<= 0		)	
			
			return super.FAILED;
		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
}
