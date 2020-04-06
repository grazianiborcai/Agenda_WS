package br.com.mind5.payment.creditCardSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchCheckRead extends ModelCheckerTemplateSimpleV2<CrecarchInfo> {

	public CrecarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 		<= 0 	||
			recordInfo.username 		== null	||
			recordInfo.codLanguage 		== null		)		
			
			return super.FAILED;
		
		
		if (recordInfo.codPayCustomer 	<= 0 	&&
			recordInfo.codCreditCard 	<= 0 	&&
			recordInfo.codUser 			<= 0 	&&
			recordInfo.creditCardId		== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
