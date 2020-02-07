package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckUserPhone extends ModelCheckerTemplateSimpleV2<CrecardInfo> {

	public CrecardCheckUserPhone(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phoneData == null)		
			return super.FAILED;
		
		
		
		if (recordInfo.codUser != recordInfo.phoneData.codUser)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_INVALID_USER_REF;
	}
}
