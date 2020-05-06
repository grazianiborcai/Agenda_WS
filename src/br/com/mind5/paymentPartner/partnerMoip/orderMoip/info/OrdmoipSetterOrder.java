package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterOrder extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.order = payloadFactory(
				value("ownId", recordInfo.ownId),
			    value("amount", recordInfo.amount),
			    value("items", recordInfo.products),
			    value("receivers", recordInfo.receivers),
			    value("customer", recordInfo.customer)
				);		

		return recordInfo;
	}
}
