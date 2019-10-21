package br.com.mind5.business.storeSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SotarchUniquifier implements InfoUniquifier<SotarchInfo> {
	
	@Override public List<SotarchInfo> uniquify(List<SotarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
