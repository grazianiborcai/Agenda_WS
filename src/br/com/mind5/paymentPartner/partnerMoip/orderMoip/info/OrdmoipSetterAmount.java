package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import static br.com.moip.helpers.PayloadFactory.payloadFactory;
import static br.com.moip.helpers.PayloadFactory.value;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterAmount extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.amount = payloadFactory(
			    value("currency", recordInfo.payordemData.codCurr),
			    value("subtotals", recordInfo.subtotal)
				);	

		return recordInfo;
	}
}
