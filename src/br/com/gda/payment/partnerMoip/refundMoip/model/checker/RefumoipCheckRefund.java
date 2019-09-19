package br.com.gda.payment.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckRefund extends ModelCheckerTemplateSimple_<RefumoipInfo> {

	public RefumoipCheckRefund() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.idOrderPartner == null )	
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
