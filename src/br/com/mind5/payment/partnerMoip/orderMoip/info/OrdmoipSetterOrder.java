package br.com.mind5.payment.partnerMoip.orderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrdmoipSetterOrder implements InfoSetter<OrdmoipInfo> {
	
	public OrdmoipInfo setAttr(OrdmoipInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.order = payloadFactory(
				value("ownId", recordInfo.ownId),
			    value("amount", recordInfo.amount),
			    value("items", recordInfo.products),
			    value("receivers", recordInfo.receivers),
			    value("customer", recordInfo.customer)
				);		

		return recordInfo;
	}
	
	
	
	private void checkArgument(OrdmoipInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
