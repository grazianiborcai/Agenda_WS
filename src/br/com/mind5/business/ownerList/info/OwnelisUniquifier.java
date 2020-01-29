package br.com.mind5.business.ownerList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OwnelisUniquifier implements InfoUniquifier<OwnelisInfo> {
	
	@Override public List<OwnelisInfo> uniquify(List<OwnelisInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
