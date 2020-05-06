package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterSubtotal extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.subtotal = payloadFactory(
			    value("shipping", 0)
				);		

		return recordInfo;
	}
}
