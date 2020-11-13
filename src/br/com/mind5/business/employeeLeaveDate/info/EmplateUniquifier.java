package br.com.mind5.business.employeeLeaveDate.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

public final class EmplateUniquifier implements InfoUniquifier<EmplateInfo> {
	
	@Override public List<EmplateInfo> uniquify(List<EmplateInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
