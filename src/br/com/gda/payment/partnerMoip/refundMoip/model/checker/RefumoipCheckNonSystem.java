package br.com.gda.payment.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckNonSystem extends ModelCheckerTemplateSimple_<RefumoipInfo> {

	public RefumoipCheckNonSystem() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner <= 0	||
			 recordInfo.codStore <= 0)	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.REFUND_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.REFUND_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
