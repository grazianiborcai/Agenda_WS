package br.com.gda.payment.setupPartner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SetuparUniquifier implements InfoUniquifier<SetuparInfo> {
	
	@Override public List<SetuparInfo> uniquify(List<SetuparInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
