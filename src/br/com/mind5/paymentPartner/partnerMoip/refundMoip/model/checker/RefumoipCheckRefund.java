package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckRefund extends ModelCheckerTemplateSimpleV2<RefumoipInfo> {

	public RefumoipCheckRefund(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 		<= 0	||
			 recordInfo.itemReceiver	== null ||
			 recordInfo.idOrderPartner 	== null 	)	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
