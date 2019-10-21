package br.com.mind5.business.materialSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatsnapUniquifier implements InfoUniquifier<MatsnapInfo> {
	
	@Override public List<MatsnapInfo> uniquify(List<MatsnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
