package br.com.gda.webhook.moipRefund.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
