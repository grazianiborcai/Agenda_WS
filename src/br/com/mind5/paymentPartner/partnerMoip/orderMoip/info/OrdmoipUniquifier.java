package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OrdmoipUniquifier implements InfoUniquifier<OrdmoipInfo> {
	
	@Override public List<OrdmoipInfo> uniquify(List<OrdmoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}