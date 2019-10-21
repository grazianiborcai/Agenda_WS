package br.com.mind5.business.employeePosition.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmposUniquifier implements InfoUniquifier<EmposInfo> {
	
	@Override public List<EmposInfo> uniquify(List<EmposInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
