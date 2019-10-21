package br.com.mind5.payment.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckSystemReceiver extends ModelCheckerTemplateSimple_<RefumoipInfo> {

	public RefumoipCheckSystemReceiver() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isSystemReceiver == true )	
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.REFUND_MOIP_IS_NOT_SYSTEM_RECEIVER;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.REFUND_MOIP_IS_NOT_SYSTEM_RECEIVER;
	}
}
