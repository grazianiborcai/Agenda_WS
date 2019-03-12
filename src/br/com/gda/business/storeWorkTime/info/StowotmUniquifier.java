package br.com.gda.business.storeWorkTime.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StowotmUniquifier implements InfoUniquifier<StowotmInfo> {
	
	@Override public List<StowotmInfo> uniquify(List<StowotmInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
