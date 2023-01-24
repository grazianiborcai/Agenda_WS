package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckWrite extends ModelCheckerTemplateSimple<CrecardInfo> {

	public CrecardCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 			<= 0 	||	
//		     recordInfo.codAddressHolder	<= 0 	||
//			 recordInfo.codPhoneHolder		<= 0 	||
			 recordInfo.expirationMonth		== null ||			 
			 recordInfo.expirationYear		== null ||
			 recordInfo.cardNumber			== null ||
			 recordInfo.cardCvc				== null ||
			 recordInfo.birthdateHolder		== null ||
			 recordInfo.cpfHolder			== null ||			 
			 recordInfo.codLanguage 		== null ||
			 recordInfo.username 			== null 	)
			
			return super.FAILED;		
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
}
