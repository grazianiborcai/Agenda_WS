package br.com.mind5.business.phoneSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PhonapUniquifier implements InfoUniquifier<PhonapInfo> {
	
	@Override public List<PhonapInfo> uniquify(List<PhonapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
