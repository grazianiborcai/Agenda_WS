package br.com.mind5.payment.storePartnerList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StoplisUniquifier implements InfoUniquifier<StoplisInfo> {
	
	@Override public List<StoplisInfo> uniquify(List<StoplisInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
