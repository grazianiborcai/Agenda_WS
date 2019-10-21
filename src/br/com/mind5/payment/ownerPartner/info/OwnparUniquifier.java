package br.com.mind5.payment.ownerPartner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OwnparUniquifier implements InfoUniquifier<OwnparInfo> {
	
	@Override public List<OwnparInfo> uniquify(List<OwnparInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
