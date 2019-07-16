package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrdmoipUniquifier implements InfoUniquifier<OrdmoipInfo> {
	
	@Override public List<OrdmoipInfo> uniquify(List<OrdmoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
