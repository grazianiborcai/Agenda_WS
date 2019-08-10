package br.com.gda.webhook.moipMultipayment.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class WokaymoipSetterIdPayment implements InfoSetter<WokaymoipInfo> {
	
	public WokaymoipInfo setAttr(WokaymoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		WokaymoipInfo result = new WokaymoipInfo();				
		result.idPaymentPartner = recordInfo.id;

		return result;
	}
	
	
	
	private void checkArgument(WokaymoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
