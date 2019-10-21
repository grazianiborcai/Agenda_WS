package br.com.mind5.business.storeWorkTime.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StowotmUniquifier implements InfoUniquifier<StowotmInfo> {
	
	@Override public List<StowotmInfo> uniquify(List<StowotmInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
