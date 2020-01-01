package br.com.mind5.payment.storePartnerSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StoparchUniquifier implements InfoUniquifier<StoparchInfo> {
	
	@Override public List<StoparchInfo> uniquify(List<StoparchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
