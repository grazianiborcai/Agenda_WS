package br.com.mind5.payment.partnerMoip.multiPayMoip.model.check;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckSysparData extends ModelCheckerTemplateSimple_<PaymoipInfo> {

	public PaymoipCheckSysparData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaymoipInfo recordInfo, Connection conn, String schemaName) {		
		if ( recordInfo.sysparData == null )				
			return super.FAILED;		
		
		if ( recordInfo.sysparData.payPartnerName == null )				
			return super.FAILED;			
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
