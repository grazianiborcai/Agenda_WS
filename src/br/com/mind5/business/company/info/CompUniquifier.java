package br.com.mind5.business.company.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CompUniquifier implements InfoUniquifier<CompInfo> {
	
	@Override public List<CompInfo> uniquify(List<CompInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
