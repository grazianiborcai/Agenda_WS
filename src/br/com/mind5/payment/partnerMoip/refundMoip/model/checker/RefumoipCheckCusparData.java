package br.com.mind5.payment.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckCusparData extends ModelCheckerTemplateSimple_<RefumoipInfo> {

	public RefumoipCheckCusparData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.cusparData == null )	
			return super.FAILED;
		
		if ( recordInfo.cusparData.customerId 	 == null ||
			 recordInfo.cusparData.codPayPartner <= 0		)	
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
