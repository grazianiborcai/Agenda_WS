package br.com.mind5.business.storeWorkTimeRange.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StoworgUniquifier implements InfoUniquifier<StoworgInfo> {
	
	@Override public List<StoworgInfo> uniquify(List<StoworgInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
