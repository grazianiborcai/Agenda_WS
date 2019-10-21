package br.com.mind5.business.employeeWorkTime.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmpwotmUniquifier implements InfoUniquifier<EmpwotmInfo> {
	
	@Override public List<EmpwotmInfo> uniquify(List<EmpwotmInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
