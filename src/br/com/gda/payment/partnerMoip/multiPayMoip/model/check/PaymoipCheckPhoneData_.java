package br.com.gda.payment.partnerMoip.multiPayMoip.model.check;

import java.sql.Connection;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckPhoneData_ extends ModelCheckerTemplateSimple<PaymoipInfo> {

	public PaymoipCheckPhoneData_() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PaymoipInfo recordInfo, Connection conn, String schemaName) {		
		if ( recordInfo.cusparData.phonapData == null )				
			return super.FAILED;		
		
		//TODO: verificar country = BR ?
		if ( recordInfo.cusparData.phonapData.codCountry == null ||
			 recordInfo.cusparData.phonapData.codArea 	 == null ||
			 recordInfo.cusparData.phonapData.number 	 == null	)				
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
