package br.com.mind5.business.storeLeaveDateRange.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StolargUniquifier implements InfoUniquifier<StolargInfo> {
	
	@Override public List<StolargInfo> uniquify(List<StolargInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
