package br.com.gda.payment.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckWriteFee extends ModelCheckerTemplateSimple<OrdmoipInfo> {

	public OrdmoipCheckWriteFee() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(OrdmoipInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.feeReceiver 	== null	||			 
			 recordInfo.codFeeCurrency 	== null	||
			 recordInfo.txtFeeCateg 	== null	||
			 recordInfo.feeAmount 		<  0		)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
