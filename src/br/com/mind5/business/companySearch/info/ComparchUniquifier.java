package br.com.mind5.business.companySearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class ComparchUniquifier implements InfoUniquifier<ComparchInfo> {
	
	@Override public List<ComparchInfo> uniquify(List<ComparchInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
