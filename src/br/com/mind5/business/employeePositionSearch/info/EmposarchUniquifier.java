package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmposarchUniquifier implements InfoUniquifier<EmposarchInfo> {
	
	@Override public List<EmposarchInfo> uniquify(List<EmposarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
