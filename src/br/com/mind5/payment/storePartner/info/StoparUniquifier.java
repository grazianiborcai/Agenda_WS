package br.com.mind5.payment.storePartner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StoparUniquifier implements InfoUniquifier<StoparInfo> {
	
	@Override public List<StoparInfo> uniquify(List<StoparInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
