package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckDelete extends ModelCheckerTemplateSimple_<CremoipInfo> {

	public CremoipCheckDelete() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.creditCardId == null)
			
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
