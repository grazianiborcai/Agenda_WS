package br.com.mind5.business.employeeMaterialSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmpmarchUniquifier implements InfoUniquifier<EmpmarchInfo> {
	
	@Override public List<EmpmarchInfo> uniquify(List<EmpmarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
