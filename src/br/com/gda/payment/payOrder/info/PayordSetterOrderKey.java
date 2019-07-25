package br.com.gda.payment.payOrder.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class PayordSetterOrderKey implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		PayordInfo result = new PayordInfo();		
		
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;

		return result;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
