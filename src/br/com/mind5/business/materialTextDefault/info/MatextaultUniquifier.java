package br.com.mind5.business.materialTextDefault.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatextaultUniquifier implements InfoUniquifier<MatextaultInfo> {
	
	@Override public List<MatextaultInfo> uniquify(List<MatextaultInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
