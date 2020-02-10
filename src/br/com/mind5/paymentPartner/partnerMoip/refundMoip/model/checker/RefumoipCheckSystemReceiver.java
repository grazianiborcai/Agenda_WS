package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckSystemReceiver extends ModelCheckerTemplateSimpleV2<RefumoipInfo> {

	public RefumoipCheckSystemReceiver(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefumoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isSystemReceiver == true )	
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUND_MOIP_IS_NOT_SYSTEM_RECEIVER;
	}
}
