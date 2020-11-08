package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;

public final class PaymoipSetterCard extends InfoSetterTemplate<PaymoipInfo> {
	
	@Override protected PaymoipInfo setAttrHook(PaymoipInfo recordInfo) {	
		recordInfo.creditCard = payloadFactory(
			    value("id" , recordInfo.crecardData.creditCardId),
			    value("cvc", recordInfo.cardCvc)
			);
		
		return recordInfo;
	}
}
