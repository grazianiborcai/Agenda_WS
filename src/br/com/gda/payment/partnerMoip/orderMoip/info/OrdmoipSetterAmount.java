package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;
import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

public final class OrdmoipSetterAmount implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.amount = payloadFactory(
			    value("currency", recordInfo.payordemData.codCurr),
			    value("subtotals", recordInfo.subtotal)
				);	

		return recordInfo;
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
