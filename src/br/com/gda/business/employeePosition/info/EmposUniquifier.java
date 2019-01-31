package br.com.gda.business.employeePosition.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmposUniquifier implements InfoUniquifier<EmposInfo> {
	
	@Override public List<EmposInfo> uniquify(List<EmposInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
