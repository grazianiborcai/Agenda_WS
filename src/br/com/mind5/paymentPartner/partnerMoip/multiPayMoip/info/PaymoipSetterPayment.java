package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;

public final class PaymoipSetterPayment extends InfoSetterTemplate<PaymoipInfo> {
	
	@Override protected PaymoipInfo setAttrHook(PaymoipInfo recordInfo) {		
		recordInfo.multipayment = payloadFactory(
			    value("installmentCount"   , 1),
			    value("statementDescriptor", recordInfo.sysparData.payPartnerName),
			    value("fundingInstrument"  , recordInfo.fundingInstrument)
			);
		
		return recordInfo;
	}
}
