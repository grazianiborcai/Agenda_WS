package br.com.gda.business.employeeMaterial.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmpmatUniquifier implements InfoUniquifier<EmpmatInfo> {
	
	@Override public List<EmpmatInfo> uniquify(List<EmpmatInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
