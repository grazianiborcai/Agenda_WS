package br.com.gda.payment.partnerMoip.multiPayMoip.model.check;

import java.sql.Connection;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckCrecardData extends ModelCheckerTemplateSimple<PaymoipInfo> {

	public PaymoipCheckCrecardData() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaymoipInfo recordInfo, Connection conn, String schemaName) {		
		if ( recordInfo.crecardData == null )				
			return super.FAILED;	
		
		if ( recordInfo.crecardData.creditCardId == null )				
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
