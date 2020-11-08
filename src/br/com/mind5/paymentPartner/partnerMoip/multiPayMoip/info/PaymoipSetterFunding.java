package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;

public final class PaymoipSetterFunding extends InfoSetterTemplate<PaymoipInfo> {
	
	@Override protected PaymoipInfo setAttrHook(PaymoipInfo recordInfo) {		
		recordInfo.fundingInstrument = payloadFactory(
			    value("method", "CREDIT_CARD"),
			    value("creditCard", recordInfo.creditCard)
			);
		
		return recordInfo;
	}
}
