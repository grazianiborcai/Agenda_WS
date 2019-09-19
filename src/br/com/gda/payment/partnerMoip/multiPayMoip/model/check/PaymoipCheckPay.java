package br.com.gda.payment.partnerMoip.multiPayMoip.model.check;

import java.sql.Connection;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckPay extends ModelCheckerTemplateSimple_<PaymoipInfo> {

	public PaymoipCheckPay() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaymoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.idOrderPartner 	== null	||
			 recordInfo.cardCvc 		== null ||
			 recordInfo.cusparData 		== null ||
			 recordInfo.setuparData		== null		)				
			
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
