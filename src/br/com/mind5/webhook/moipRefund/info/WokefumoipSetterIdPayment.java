package br.com.mind5.webhook.moipRefund.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class WokefumoipSetterIdPayment implements InfoSetter<WokefumoipInfo> {
	
	public WokefumoipInfo setAttr(WokefumoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		WokefumoipInfo result = new WokefumoipInfo();				
		result.idPaymentPartner = recordInfo.title;

		return result;
	}
	
	
	
	private void checkArgument(WokefumoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
