package br.com.gda.business.personSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PerarchUniquifier implements InfoUniquifier<PerarchInfo> {
	
	@Override public List<PerarchInfo> uniquify(List<PerarchInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
