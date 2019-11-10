package br.com.mind5.business.storeWorkTimeSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StowotarchUniquifier implements InfoUniquifier<StowotarchInfo> {
	
	@Override public List<StowotarchInfo> uniquify(List<StowotarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
