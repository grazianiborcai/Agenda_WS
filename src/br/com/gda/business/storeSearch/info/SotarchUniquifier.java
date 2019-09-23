package br.com.gda.business.storeSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SotarchUniquifier implements InfoUniquifier<SotarchInfo> {
	
	@Override public List<SotarchInfo> uniquify(List<SotarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
