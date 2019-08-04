package br.com.gda.payment.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckSystemReceiver extends ModelCheckerTemplateSimple<RefumoipInfo> {

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
