package br.com.mind5.business.employeeWorkTimeConflict.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmpwocoUniquifier implements InfoUniquifier<EmpwocoInfo> {
	
	@Override public List<EmpwocoInfo> uniquify(List<EmpwocoInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
