package br.com.mind5.payment.refundOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentPartner.info.Paypar;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemCheckIsMoip extends ModelCheckerTemplateSimple<RefemInfo> {
	
	public RefemCheckIsMoip(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefemInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codPayPartner != Paypar.MOIP.getCodPayPartner() )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_ITEM_MANDATORY_FIELD_EMPTY;
	}
}
