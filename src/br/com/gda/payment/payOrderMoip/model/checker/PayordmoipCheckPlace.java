package br.com.gda.payment.payOrderMoip.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderMoip.info.PayordmoipInfo;

public final class PayordmoipCheckPlace extends ModelCheckerTemplateSimple<PayordmoipInfo> {

	public PayordmoipCheckPlace() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(PayordmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.payordData == null )	
			return super.FAILED;
		
		if ( recordInfo.payordData.payordems == null )	
			return super.FAILED;
		
		if ( recordInfo.payordData.payordems.isEmpty() )	
			return super.FAILED;
		
		
		for (PayordemInfo eachItem : recordInfo.payordData.payordems) {
			if (eachItem.matData == null)
				return super.FAILED;
		}
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
