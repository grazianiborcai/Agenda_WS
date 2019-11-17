package br.com.mind5.business.employeeLeaveDateSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmplarchUniquifier implements InfoUniquifier<EmplarchInfo> {
	
	@Override public List<EmplarchInfo> uniquify(List<EmplarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
