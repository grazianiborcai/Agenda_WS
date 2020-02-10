package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PaymoipUniquifier implements InfoUniquifier<PaymoipInfo> {
	
	@Override public List<PaymoipInfo> uniquify(List<PaymoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
