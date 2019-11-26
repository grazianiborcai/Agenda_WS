package br.com.mind5.business.employeeSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmparchUniquifier implements InfoUniquifier<EmparchInfo> {
	
	@Override public List<EmparchInfo> uniquify(List<EmparchInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
