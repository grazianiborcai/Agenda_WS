package br.com.gda.payment.ownerPartner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OwnparUniquifier implements InfoUniquifier<OwnparInfo> {
	
	@Override public List<OwnparInfo> uniquify(List<OwnparInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
