package br.com.mind5.business.employeeWorkTimeSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmpwotarchUniquifier implements InfoUniquifier<EmpwotarchInfo> {
	
	@Override public List<EmpwotarchInfo> uniquify(List<EmpwotarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
