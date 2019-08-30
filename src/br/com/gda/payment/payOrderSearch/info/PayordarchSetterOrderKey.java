package br.com.gda.payment.payOrderSearch.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayordarchSetterOrderKey implements InfoSetter<PayordarchInfo> {
	
	public PayordarchInfo setAttr(PayordarchInfo recordInfo) {
		checkArgument(recordInfo);
		
		PayordarchInfo result = new PayordarchInfo();		
		
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
	
	
	
	private void checkArgument(PayordarchInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
