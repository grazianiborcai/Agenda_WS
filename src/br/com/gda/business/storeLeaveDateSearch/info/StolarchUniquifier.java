package br.com.gda.business.storeLeaveDateSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StolarchUniquifier implements InfoUniquifier<StolarchInfo> {
	
	@Override public List<StolarchInfo> uniquify(List<StolarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
