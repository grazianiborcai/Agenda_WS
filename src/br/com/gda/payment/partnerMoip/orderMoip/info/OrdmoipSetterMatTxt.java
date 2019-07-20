package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrdmoipSetterMatTxt implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.productTxt = recordInfo.payordemData.matData.txtMat;
		recordInfo.detailTxt = recordInfo.payordemData.matData.txtMat;

		return recordInfo;
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
