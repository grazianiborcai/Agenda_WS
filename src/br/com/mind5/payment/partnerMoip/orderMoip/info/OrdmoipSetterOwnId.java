package br.com.mind5.payment.partnerMoip.orderMoip.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrdmoipSetterOwnId implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.ownId = String.valueOf(recordInfo.payordemData.codOwner)
				         + "-"
				         + String.valueOf(recordInfo.payordemData.codPayOrder)
				         + "-"
				         + String.valueOf(recordInfo.payordemData.codPayOrderItem);
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
