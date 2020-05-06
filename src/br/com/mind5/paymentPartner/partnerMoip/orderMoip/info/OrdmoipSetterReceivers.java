package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterReceivers extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		Map<String, Object> receiver = payloadFactory(
				value("moipAccount", recordInfo.account),
			    value("type", "PRIMARY")
				);	

		recordInfo.receivers.add(receiver);
		return recordInfo;
	}
}
