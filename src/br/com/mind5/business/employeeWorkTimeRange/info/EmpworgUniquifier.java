package br.com.mind5.business.employeeWorkTimeRange.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmpworgUniquifier implements InfoUniquifier<EmpworgInfo> {
	
	@Override public List<EmpworgInfo> uniquify(List<EmpworgInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
