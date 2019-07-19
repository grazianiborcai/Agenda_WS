package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrdmoipSetterMatOwnId implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.ownId = String.valueOf(recordInfo.payordemData.codOwner)
				         + "-"
				         + String.valueOf(recordInfo.payordemData.codPayOrder)
				         + "-"
				         + String.valueOf(recordInfo.payordemData.itemNum);
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
