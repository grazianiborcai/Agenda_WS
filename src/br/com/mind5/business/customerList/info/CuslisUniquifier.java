package br.com.mind5.business.customerList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CuslisUniquifier implements InfoUniquifier<CuslisInfo> {
	
	@Override public List<CuslisInfo> uniquify(List<CuslisInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
