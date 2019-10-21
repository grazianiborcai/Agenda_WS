package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.Paypar;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckIsMoip extends ModelCheckerTemplateSimple_<CrecardInfo> {

	public CrecardCheckIsMoip() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CrecardInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner == Paypar.MOIP.getCodPayPartner() )
			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.CREDIT_CARD_PAYPAR_NOT_MOIP;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.CREDIT_CARD_PAYPAR_NOT_MOIP;
	}
}
