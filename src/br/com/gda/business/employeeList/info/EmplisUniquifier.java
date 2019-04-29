package br.com.gda.business.employeeList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmplisUniquifier implements InfoUniquifier<EmplisInfo> {
	
	@Override public List<EmplisInfo> uniquify(List<EmplisInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
