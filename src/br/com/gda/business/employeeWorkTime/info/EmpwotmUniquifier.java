package br.com.gda.business.employeeWorkTime.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmpwotmUniquifier implements InfoUniquifier<EmpwotmInfo> {
	
	@Override public List<EmpwotmInfo> uniquify(List<EmpwotmInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
