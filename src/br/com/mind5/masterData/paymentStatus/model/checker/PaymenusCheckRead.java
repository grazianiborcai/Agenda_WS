package br.com.mind5.masterData.paymentStatus.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class PaymenusCheckRead extends ModelCheckerTemplateSimpleV2<PaymenusInfo> {
	
	public PaymenusCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PaymenusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPaymentStatus == null ||
			 recordInfo.codLanguage 	 == null 	)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYMENT_STATUS_MANDATORY_FIELD_EMPTY;
	}
}