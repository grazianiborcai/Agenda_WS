package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmplevateUniquifier implements InfoUniquifier<EmplevateInfo> {
	
	@Override public List<EmplevateInfo> uniquify(List<EmplevateInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
