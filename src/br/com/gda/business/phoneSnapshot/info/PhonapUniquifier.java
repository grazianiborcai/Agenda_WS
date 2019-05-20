package br.com.gda.business.phoneSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PhonapUniquifier implements InfoUniquifier<PhonapInfo> {
	
	@Override public List<PhonapInfo> uniquify(List<PhonapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
