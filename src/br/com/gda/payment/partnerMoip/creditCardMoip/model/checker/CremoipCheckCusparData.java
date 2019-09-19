package br.com.gda.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckCusparData extends ModelCheckerTemplateSimple_<CremoipInfo> {

	public CremoipCheckCusparData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cusparData == null)
			return super.FAILED;
		
		
		if (recordInfo.cusparData.codPayPartner <= 0	||
			recordInfo.cusparData.customerId	== null		)			
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_MOIP_EMPTY_CUSPAR;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_MOIP_EMPTY_CUSPAR;
	}
}
