package br.com.mind5.webhook.moipMultipayment.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
