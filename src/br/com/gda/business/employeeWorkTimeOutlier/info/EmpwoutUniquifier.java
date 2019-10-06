package br.com.gda.business.employeeWorkTimeOutlier.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmpwoutUniquifier implements InfoUniquifier<EmpwoutInfo> {
	
	@Override public List<EmpwoutInfo> uniquify(List<EmpwoutInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
