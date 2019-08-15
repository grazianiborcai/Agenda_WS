package br.com.gda.business.customerList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CuslisUniquifier implements InfoUniquifier<CuslisInfo> {
	
	@Override public List<CuslisInfo> uniquify(List<CuslisInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
