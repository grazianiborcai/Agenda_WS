package br.com.mind5.business.materialSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatarchUniquifier implements InfoUniquifier<MatarchInfo> {
	
	@Override public List<MatarchInfo> uniquify(List<MatarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
