package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckRead extends ModelCheckerTemplateSimpleV2<CrecardInfo> {

	public CrecardCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 		<= 0 	||
			recordInfo.codCreditCard 	<= 0 	||
			recordInfo.username 		== null	||
			recordInfo.codLanguage 		== null		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MANDATORY_FIELD_EMPTY;
	}
}
